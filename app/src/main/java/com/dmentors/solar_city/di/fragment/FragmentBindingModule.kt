package com.dmentors.solar_city.di.fragment

import com.dmentors.solar_city.presentation.calendar.CalendarFragment
import com.dmentors.solar_city.presentation.meeting.MeetingFragment
import com.dmentors.solar_city.presentation.meeting.MeetingSelectionFragment
import com.dmentors.solar_city.presentation.meeting.NewMeetingFragment
import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import com.dmentors.solar_city.presentation.reports.ReportsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("unused")
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindMeetingFragment(): MeetingFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindMeetingSelectionFragment(): MeetingSelectionFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindNewMeetingFragment(): NewMeetingFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindCakendarFragment(): CalendarFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindBlogFragment(): BlogFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindReportsFragment(): ReportsFragment
}