package com.dmentors.solar_city.presentation.calendar

import androidx.lifecycle.Observer
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.extensions.toast
import com.dmentors.solar_city.presentation.meeting.MeetingFragment
import kotlinx.android.synthetic.main.fragment_calendar.*

class CalendarFragment : BaseFragment<CalendarViewModel>() {

    companion object {

        const val BACKSTACK_CALENDAR = "backstack_calendar"

        fun newInstance(): CalendarFragment {
            //TODO constructor for parameters
            val fragment = CalendarFragment()
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_calendar

    override fun initViews() {
        calendarView.showCurrentMonthPage()
        calendarView.setOnDayClickListener {
            viewModel.onDayClicked(it.calendar)
        }
        calendarAddMeeting.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_container,
                    MeetingFragment()
                )
                .addToBackStack(BACKSTACK_CALENDAR)
                .commit()
        }
    }

    override fun subscribeToViewModel() {
        viewModel.error.observe(this, Observer {
            toast(it.localizedMessage ?: "Ошибка")
        })
        viewModel.loading.observe(this, Observer {

        })
        viewModel.pastEventsData.observe(this, Observer {
            calendarView.setEvents(it)
        })
        viewModel.pastFutureData.observe(this, Observer {
            calendarView.setHighlightedDays(it)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getEvents()
    }
}