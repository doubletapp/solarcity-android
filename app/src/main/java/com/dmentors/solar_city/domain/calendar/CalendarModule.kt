package com.dmentors.solar_city.domain.calendar

import com.dmentors.solar_city.domain.meeting.EventsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalendarModule {
    @Provides
    @Singleton
    fun provideCalendarInteractor(dao: EventsDao): CalendarInteractor =
        CalendarInteractor(dao)

}