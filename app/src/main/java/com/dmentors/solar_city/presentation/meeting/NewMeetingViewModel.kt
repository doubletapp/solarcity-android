package com.dmentors.solar_city.presentation.meeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.meeting.Meeting

class NewMeetingViewModel: BaseViewModel() {

    private val mutableMeetingsData = MutableLiveData<MutableList<Meeting>>()
    val meetingsData: LiveData<MutableList<Meeting>> get() = mutableMeetingsData

    private val items = mutableListOf(Meeting())

    fun getList() {
        mutableMeetingsData.postValue(items)
    }

    fun addMeeting(name: String, type: String) {
        if (name.isEmpty()) {
            mutableError.postValue(Throwable(ArchApplication.appContext?.getString(R.string.empty_name_error)))
            return
        }
        items.last().name = name
        items.last().type = type
        items.last().isNew = false
        items.add(Meeting())
        mutableMeetingsData.postValue(items)
    }
    fun editMeeting(name: String, type: String, position: Int) {
        if (name.isEmpty()) {
            mutableError.postValue(Throwable(ArchApplication.appContext?.getString(R.string.empty_name_error)))
            return
        }
        items[position].name = name
        items[position].type = type
        items[position].isEditing = false
        mutableMeetingsData.postValue(items)

    }

    fun removeMeeting(item: Meeting) {
        items.remove(item)
        mutableMeetingsData.postValue(items)
    }
}