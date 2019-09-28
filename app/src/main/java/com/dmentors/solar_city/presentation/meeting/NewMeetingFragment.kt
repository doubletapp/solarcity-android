package com.dmentors.solar_city.presentation.meeting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.domain.meeting.Meeting
import com.dmentors.solar_city.extensions.toast
import kotlinx.android.synthetic.main.fragment_new_meetings.*
import kotlinx.android.synthetic.main.recycler_item_meeting.view.*
import android.graphics.Typeface
import android.widget.TextView
import android.content.Context
import androidx.core.content.res.ResourcesCompat


class NewMeetingFragment : BaseFragment<NewMeetingViewModel>() {

    companion object {

        fun newInstance(callback: MeetingCallback): NewMeetingFragment {
            val fragment = NewMeetingFragment()
            fragment.callback = callback
            return fragment
        }
    }

    private var callback: MeetingCallback? = null
    private val adapter = NewMeetengsAdapter(
        object : NewMeetengsAdapter.NewMeetingAdapterCallback {
            override fun removeMeeting(item: Meeting) {
                viewModel.removeMeeting(item)
            }

            override fun editMeeting(name: String, type: String, position: Int) {
                viewModel.editMeeting(name, type, position)
            }

            override fun addMeeting(name: String, type: String) {
                viewModel.addMeeting(name, type)
            }

        }
    )

    override fun getLayoutId(): Int = R.layout.fragment_new_meetings

    override fun initViews() {
        recyclerLayout.adapter = adapter
        viewModel.getList()
    }

    override fun subscribeToViewModel() {
        viewModel.loading.observe(this, Observer { loading ->
            recyclerProgress.visibility = if (loading) View.VISIBLE else View.GONE
        })
        viewModel.error.observe(this, Observer { error ->
            toast(error.localizedMessage ?: "Ошибка")
        })
        viewModel.meetingsData.observe(this, Observer { list ->
            adapter.items = list
            callback?.meetingsListChanged(list)
        })
    }
}

class NewMeetengsAdapter(
    private val callback: NewMeetingAdapterCallback
) :
    RecyclerView.Adapter<NewMeetengsAdapter.MeetingViewHolder>() {

    var items: MutableList<Meeting> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder =
        MeetingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item_meeting,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MeetingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {

            val item = items[position]

            itemView.meetingItemTitle.text = item.name
            itemView.meetingItemNameET.setText(item.name)


            val adapter = MyCustomAdapter(
                itemView.context,
                itemView.resources.getStringArray(R.array.meeting_type)
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            itemView.meetingItemTypeSelector.adapter = adapter

            itemView.meetingItemCountValue.text =
                itemView.context.getString(R.string.meeting_item_count_pattern, position + 1)

            itemView.meetingItemTypeSelector.setSelection(
                if (item.type.isNotEmpty()) {
                    itemView.resources.getStringArray(R.array.meeting_type).indexOf(item.type)
                } else {
                    0
                }
            )

            itemView.meetingItemDeleteBtn.setOnClickListener {
                callback.removeMeeting(item)
            }

            itemView.meetingItemEditBtn.setOnClickListener {
                items.forEach {
                    it.isEditing = false
                }
                item.isEditing = true
                items = items.dropLast(1).toMutableList()
                notifyDataSetChanged()
            }

            when {
                item.isNew -> {
                    itemView.meetingItemTopContainer.visibility = View.GONE
                    itemView.meetingItemCollapseContainer.visibility = View.VISIBLE
                    itemView.meetingItemAddBtn.text = itemView.context.getString(R.string.add)
                    itemView.meetingItemAddBtn.setOnClickListener {
                        callback.addMeeting(
                            itemView.meetingItemNameET.text.toString(),
                            itemView.meetingItemTypeSelector.selectedItem.toString()
                        )
                    }
                }
                item.isEditing -> {
                    itemView.meetingItemAddBtn.text = itemView.context.getString(R.string.save)
                    itemView.meetingItemAddBtn.setOnClickListener {
                        callback.editMeeting(
                            itemView.meetingItemNameET.text.toString(),
                            itemView.meetingItemTypeSelector.selectedItem.toString(),
                            position
                        )
                    }
                    itemView.meetingItemTopContainer.visibility = View.GONE
                    itemView.meetingItemCollapseContainer.visibility = View.VISIBLE

                }
                else -> {
                    itemView.meetingItemTopContainer.visibility = View.VISIBLE
                    itemView.meetingItemCollapseContainer.visibility = View.GONE
                }
            }
        }
    }

    interface NewMeetingAdapterCallback {
        fun addMeeting(name: String, type: String)
        fun editMeeting(name: String, type: String, position: Int)
        fun removeMeeting(item: Meeting)
    }
}

// try this custom adapter for spinner
class MyCustomAdapter(context: Context, var list: Array<String>) :
    ArrayAdapter<String>(context, 0, list) {
    var defaultPosition: Int = 0
        private set

    fun setDefaultPostion(position: Int) {
        this.defaultPosition = position
    }

    override fun getDropDownView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustom(position, convertView, parent)
    }

    fun getCustom(position: Int, convertView: View?, parent: ViewGroup): View {

        val row = LayoutInflater.from(context).inflate(
            android.R.layout.simple_spinner_item, parent, false
        )
        val label = row.findViewById<View>(android.R.id.text1) as TextView
        val tf = ResourcesCompat.getFont(context, R.font.geometria_regular)
        label.typeface = tf
        label.text = list[position]

        return row
    }

    fun getCustomView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {

        val row = LayoutInflater.from(context).inflate(
            android.R.layout.simple_spinner_item, parent, false
        )
        val label = row.findViewById<View>(android.R.id.text1) as TextView
        val tf = ResourcesCompat.getFont(context, R.font.geometria_regular)
        label.typeface = tf
        label.text = list[position]

        return row
    }
}