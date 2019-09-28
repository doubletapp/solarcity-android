package com.dmentors.solar_city.domain.meeting

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "Event")
@TypeConverters(EventConverter::class)
data class Event(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "event_date")
    var eventDate: Long = 0,

    @ColumnInfo(name = "meetingsList")
    var meetingsList: List<Meeting> = listOf()
)

class EventConverter {
    @TypeConverter
    fun fromMeetingsList(list: List<Meeting>?): String {
        val type = object : TypeToken<List<Meeting>>() {}.type
        return Gson().toJson(list, type)
    }

    @TypeConverter
    fun toMeetingsList(str: String): List<Meeting> {
        val gson = Gson()
        val type = object : TypeToken<List<Meeting>>() {}.type
        return gson.fromJson(str, type)
    }
}