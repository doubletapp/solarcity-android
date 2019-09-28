package com.dmentors.solar_city.domain.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.dmentors.solar_city.domain.meeting.Event
import com.dmentors.solar_city.domain.meeting.EventsDao

@Database(
    entities = [
        Event::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun eventsDao(): EventsDao

    companion object {
        const val NAME = "SolarCityDatabase"
    }
}