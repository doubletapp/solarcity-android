package com.dmentors.solar_city.presentation.meeting

import androidx.lifecycle.Observer
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.domain.meeting.Meeting
import com.dmentors.solar_city.extensions.toast
import kotlinx.android.synthetic.main.fragment_meeting.*
import java.util.*

class MeetingFragment : BaseFragment<MeetingFragmentViewModel>(), MeetingCallback {


    override fun meetingsListChanged(list: List<Meeting>) {
        viewModel.meetingsListChanged(list)
    }

    override fun openAddNewScreen() {
        childFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                NewMeetingFragment.newInstance(this@MeetingFragment)
            )
            .addToBackStack(BACKSTACK_MEETING)
            .commit()
    }

    companion object {
        const val BACKSTACK_MEETING = "meeting_bs"

        fun newInstance(calendar: Calendar): MeetingFragment {
            val fragment = MeetingFragment()
            fragment.calendar = calendar
            return fragment
        }
    }

    private var calendar: Calendar? = null

    override fun getLayoutId(): Int = R.layout.fragment_meeting

    override fun initViews() {
        childFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                MeetingSelectionFragment.newInstance(this@MeetingFragment)
            )
            .addToBackStack(BACKSTACK_MEETING)
            .commit()

        meetingDoneBtn.setOnClickListener {
            viewModel.saveEvent(calendar)
        }
        meetingBackBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun subscribeToViewModel() {
        viewModel.eventAdded.observe(this, Observer {

        })
    }
}

interface MeetingCallback {
    fun openAddNewScreen()
    fun meetingsListChanged(list: List<Meeting>)
}