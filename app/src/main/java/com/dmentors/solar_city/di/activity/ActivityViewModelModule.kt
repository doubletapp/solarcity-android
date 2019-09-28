package com.dmentors.solar_city.di.activity

import androidx.lifecycle.ViewModelProviders
import com.dmentors.solar_city.di.ViewModelFactory
import com.dmentors.solar_city.presentation.main.MainViewModel
import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.presentation.signIn.SignInActivity
import com.dmentors.solar_city.presentation.signIn.SignInViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityViewModelModule {

    @Provides
    fun provideMainViewModel(viewModelFactory: ViewModelFactory, mainActivity: MainActivity): MainViewModel =
            ViewModelProviders.of(mainActivity, viewModelFactory).get(MainViewModel::class.java)

    @Provides
    fun provideSignInActivityViewModel(viewModelFactory: ViewModelFactory, activity: SignInActivity) : SignInViewModel =
        ViewModelProviders.of(activity, viewModelFactory).get(SignInViewModel::class.java)
}