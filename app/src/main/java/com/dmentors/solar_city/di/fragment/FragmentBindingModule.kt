package com.dmentors.solar_city.di.fragment

import com.dmentors.solar_city.presentation.signIn.TestFragment
import com.dmentors.solar_city.presentation.calendar.CalendarFragment
import com.dmentors.solar_city.presentation.meeting.MeetingFragment
import com.dmentors.solar_city.presentation.meeting.MeetingSelectionFragment
import com.dmentors.solar_city.presentation.meeting.NewMeetingFragment
import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.chat.ChatFragment
import com.dmentors.solar_city.presentation.chat.ChatsFragment
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import com.dmentors.solar_city.presentation.reports.ReportsFragment
import com.dmentors.solar_city.presentation.recommendation.RecommendationFragment
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
    abstract fun bindChatsFragment(): ChatsFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindChatFragment(): ChatFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindRecommendationFragment(): RecommendationFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindReportsFragment(): ReportsFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindTestFragment(): TestFragment
}