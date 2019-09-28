package com.dmentors.solar_city.di

import androidx.lifecycle.ViewModel
import com.dmentors.solar_city.domain.calendar.CalendarInteractor
import com.dmentors.solar_city.domain.main.MainInteractor
import com.dmentors.solar_city.domain.signIn.SignInInteractor
import com.dmentors.solar_city.presentation.calendar.CalendarViewModel
import com.dmentors.solar_city.presentation.blog.BlogViewModel
import com.dmentors.solar_city.presentation.main.MainViewModel
import com.dmentors.solar_city.presentation.meeting.MeetingFragmentViewModel
import com.dmentors.solar_city.presentation.meeting.MeetingSelectionViewModel
import com.dmentors.solar_city.presentation.meeting.NewMeetingViewModel
import com.dmentors.solar_city.presentation.profile.ProfileViewModel
import com.dmentors.solar_city.presentation.signIn.SignInViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainInteractor: MainInteractor): ViewModel =
        MainViewModel(mainInteractor)

    @Provides
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(interactor: SignInInteractor): ViewModel =
        SignInViewModel(interactor)

    @Provides
    @IntoMap
    @ViewModelKey(MeetingFragmentViewModel::class)
    fun bindMeetingFragmentViewModel(): ViewModel =
        MeetingFragmentViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(MeetingSelectionViewModel::class)
    fun bindMeetingSelectionViewModel(): ViewModel =
        MeetingSelectionViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(NewMeetingViewModel::class)
    fun bindNewMeetingViewModel(): ViewModel =
        NewMeetingViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(CalendarViewModel::class)
    fun bindCalendarViewModel(interactor: CalendarInteractor): ViewModel =
        CalendarViewModel(interactor)

    @Provides
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(): ViewModel =
        ProfileViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(BlogViewModel::class)
    fun bindBlogViewModel(): ViewModel =
        BlogViewModel()
}