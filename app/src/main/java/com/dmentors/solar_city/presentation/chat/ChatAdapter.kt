package com.dmentors.solar_city.presentation.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dmentors.solar_city.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_message_foreign.*
import kotlinx.android.synthetic.main.item_message_self.*

class ChatAdapter(
    itemCallback: MessageItemCallback = MessageItemCallback()
) : ListAdapter<Message, RecyclerView.ViewHolder>(itemCallback) {

    companion object {
        const val TYPE_SELF = 1001
        const val TYPE_FOREIGN = 1002
    }

    var items: ArrayList<Message> = ArrayList()

    override fun submitList(list: MutableList<Message>?) {
        super.submitList(list)
        items = ArrayList()
        list?.forEach { items.add(it.copy()) }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position).type) {
        Message.Type.SELF -> TYPE_SELF
        Message.Type.FOREIGN -> TYPE_FOREIGN
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        TYPE_SELF -> MessageSelfViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message_self, parent, false)
        )
        else -> MessageForeignViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message_foreign, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position).type) {
            Message.Type.SELF -> (holder as? MessageSelfViewHolder)?.bind(getItem(position))
            Message.Type.FOREIGN -> (holder as? MessageForeignViewHolder)?.bind(getItem(position))
        }
    }

    fun addMessage(message: Message) {
        items.add(0, message)
        submitList(items.toMutableList())
    }

    inner class MessageSelfViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Message) {
            messageSelfText.text = item.message
        }
    }

    inner class MessageForeignViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Message) {
            messageForeignText.text = item.message
        }
    }
}