package com.dmentors.solar_city.presentation.calendar

import android.view.View
import androidx.lifecycle.Observer
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.domain.meeting.Event
import com.dmentors.solar_city.extensions.toast
import com.dmentors.solar_city.presentation.meeting.MeetingFragment
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*
import java.util.stream.Collectors

class CalendarFragment : BaseFragment<CalendarViewModel>() {

    companion object {

        const val TAG: String = "CalendarFragment"
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
            calendarAddMeeting.isEnabled =
                it.calendar.timeInMillis >= Calendar.getInstance().timeInMillis
            viewModel.onDayClicked(it.calendar)
        }
        calendarAddMeeting.setOnClickListener {
            activity
                ?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(
                    android.R.id.content,
                    MeetingFragment.newInstance(calendarView.firstSelectedDate)
                )
                ?.addToBackStack(BACKSTACK_CALENDAR)
                ?.commit()
        }
        calendarBackBtn.setOnClickListener {
            activity?.onBackPressed()
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
        viewModel.eventInfoData.observe(this, Observer {
            it?.let {
                calendarEventCard.visibility = View.VISIBLE
                calendarMeetingTitle.text = it.meetingsList.stream().map { it.name }.collect(
                    Collectors.joining(
                        ", "
                    )
                )
                if (it.eventDate > Calendar.getInstance().timeInMillis) {
                    calendarEventActionBtn.text = "Я иду"
                    calendarEventActionBtn.setOnClickListener {
                        toast("Заявка отправлена. Ожидайте подтверждения!")
                    }
                }
            } ?: run {
                calendarEventCard.visibility = View.GONE
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getEvents()
    }

    fun eventAdded(event: Event) {
        viewModel.eventAdded(event)
    }
}