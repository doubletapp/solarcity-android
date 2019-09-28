package com.dmentors.solar_city.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applandeo.materialcalendarview.EventDay
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.calendar.CalendarInteractor
import com.dmentors.solar_city.domain.meeting.Event
import com.dmentors.solar_city.domain.meeting.Meeting
import java.util.*
import java.util.concurrent.TimeUnit

class CalendarViewModel(
    private val interactor: CalendarInteractor
) : BaseViewModel() {

    private val mutablePastEventsData = MutableLiveData<List<EventDay>>()
    val pastEventsData: LiveData<List<EventDay>> get() = mutablePastEventsData

    private val mutableFutureEventsData = MutableLiveData<List<EventDay>>()
    val pastFutureData: LiveData<List<EventDay>> get() = mutableFutureEventsData

    private val mutableEventInfoData = MutableLiveData<Event?>()
    val eventInfoData: LiveData<Event?> get() = mutableEventInfoData

    private val mutableOpenAddEventData = MutableLiveData<Void>()
    val openAddEventData: LiveData<Void> get() = mutableOpenAddEventData

    private val events = mutableListOf<Event>()

    fun getEvents() {
        val past = mutableListOf<EventDay>()
        val currTime = Calendar.getInstance().timeInMillis
        //TODO Mock
        events.add(
            Event(
                eventDate = currTime - TimeUnit.DAYS.toMillis(2),
                meetingsList = listOf(
                    Meeting(
                        "Встреча на ипподроме",
                        "Встреча",
                        false
                    )
                )
            )
        )
        events.add(
            Event(
                eventDate = currTime + TimeUnit.DAYS.toMillis(2),
                meetingsList = listOf(
                    Meeting(
                        "Обучение наставников",
                        "Встреча",
                        false
                    )
                )
            )
        )
        events.forEach {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = it.eventDate

            past.add(
                if (currTime > calendar.timeInMillis) {
                    EventDay(calendar, R.drawable.ic_dot_past)
                } else {
                    EventDay(calendar, R.drawable.ic_dot_current)
                }
            )
        }
        mutablePastEventsData.postValue(past)
    }

    fun onDayClicked(calendar: Calendar) {
        events.firstOrNull {
            val dayCalendar = Calendar.getInstance()
            dayCalendar.timeInMillis = it.eventDate
            return@firstOrNull calendar.get(Calendar.DAY_OF_YEAR) == dayCalendar.get(Calendar.DAY_OF_YEAR) &&
                    calendar.get(Calendar.YEAR) == dayCalendar.get(Calendar.YEAR)
        }?.let {
            mutableEventInfoData.postValue(it)
        } ?: kotlin.run {
            mutableEventInfoData.postValue(null)
        }
    }

    fun eventAdded(event: Event) {
        events.firstOrNull {
            val eventCalendar = Calendar.getInstance()
            eventCalendar.timeInMillis = it.eventDate

            val newEventCalendar = Calendar.getInstance()
            newEventCalendar.timeInMillis = event.eventDate

            newEventCalendar.get(Calendar.DAY_OF_YEAR) == eventCalendar.get(Calendar.DAY_OF_YEAR) &&
                    newEventCalendar.get(Calendar.YEAR) == eventCalendar.get(Calendar.YEAR)
        }?.let {
            mutableError.postValue(Throwable("Вы можете добавить не более одного мероприятия на деньы"))
        } ?: run {
            events.add(event)
            val past = mutableListOf<EventDay>()
            val currTime = Calendar.getInstance().timeInMillis
            events.forEach {
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = it.eventDate
                past.add(
                    if (currTime > calendar.timeInMillis) {
                        EventDay(calendar, R.drawable.ic_dot_past)
                    } else {
                        EventDay(calendar, R.drawable.ic_dot_current)
                    }
                )
            }
            mutablePastEventsData.postValue(past)
        }
    }
}