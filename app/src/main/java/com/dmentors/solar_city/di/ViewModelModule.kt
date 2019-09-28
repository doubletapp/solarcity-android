package com.dmentors.solar_city.di

import androidx.lifecycle.ViewModel
import com.dmentors.solar_city.domain.just.JustInteractor
import com.dmentors.solar_city.domain.main.MainInteractor
import com.dmentors.solar_city.presentation.blog.BlogViewModel
import com.dmentors.solar_city.presentation.just.JustViewModel
import com.dmentors.solar_city.presentation.main.MainViewModel
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
    @ViewModelKey(JustViewModel::class)
    fun bindJustViewModel(justInteractor: JustInteractor): ViewModel =
        JustViewModel(justInteractor)

    @Provides
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(): ViewModel =
        SignInViewModel()

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