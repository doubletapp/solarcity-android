package com.dmentors.solar_city.presentation.meeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.meeting.Event
import com.dmentors.solar_city.domain.meeting.Meeting
import java.util.*

class MeetingFragmentViewModel(

) : BaseViewModel() {

    private val mutableEventAdded = MutableLiveData<Event>()
    val eventAdded: LiveData<Event> get() = mutableEventAdded

    private var meetingsList = listOf<Meeting>()

    fun meetingsListChanged(list: List<Meeting>) {
        meetingsList = list
    }

    fun saveEvent(calendar: Calendar?) {
        calendar?.let {
            val event = Event(
                eventDate = it.timeInMillis,
                meetingsList = meetingsList)
            mutableEventAdded.postValue(event)
        }

    }
}