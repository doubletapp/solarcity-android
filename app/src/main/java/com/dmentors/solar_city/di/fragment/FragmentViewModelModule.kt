package com.dmentors.solar_city.di.fragment

import androidx.lifecycle.ViewModelProviders
import com.dmentors.solar_city.di.ViewModelFactory
import com.dmentors.solar_city.presentation.calendar.CalendarFragment
import com.dmentors.solar_city.presentation.calendar.CalendarViewModel
import com.dmentors.solar_city.presentation.meeting.*
import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.blog.BlogViewModel
import com.dmentors.solar_city.presentation.chat.ChatFragment
import com.dmentors.solar_city.presentation.chat.ChatViewModel
import com.dmentors.solar_city.presentation.chat.ChatsFragment
import com.dmentors.solar_city.presentation.chat.ChatsViewModel
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import com.dmentors.solar_city.presentation.profile.ProfileViewModel
import com.dmentors.solar_city.presentation.reports.ReportsFragment
import com.dmentors.solar_city.presentation.reports.ReportsViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelModule {

    @Provides
    fun provideMeetingFragmetnViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: MeetingFragment
    ): MeetingFragmentViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(MeetingFragmentViewModel::class.java)

    @Provides
    fun provideMeetingSelectionViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: MeetingSelectionFragment
    ): MeetingSelectionViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(MeetingSelectionViewModel::class.java)

    @Provides
    fun provideNewMeetingViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: NewMeetingFragment
    ): NewMeetingViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(NewMeetingViewModel::class.java)

    @Provides
    fun provideCalendarViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: CalendarFragment
    ): CalendarViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(CalendarViewModel::class.java)

    @Provides
    fun provideProfileViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ProfileFragment
    ): ProfileViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ProfileViewModel::class.java)

    @Provides
    fun provideBlogViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: BlogFragment
    ): BlogViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(BlogViewModel::class.java)

    @Provides
    fun provideChatsViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ChatsFragment
    ): ChatsViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ChatsViewModel::class.java)

    @Provides
    fun provideChatViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ChatFragment
    ): ChatViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ChatViewModel::class.java)

    @Provides
    fun provideReportViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ReportsFragment
    ): ReportsViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ReportsViewModel::class.java)

}