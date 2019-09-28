package com.dmentors.solar_city.di.activity

import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.presentation.signIn.SignInActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("unused")
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    abstract fun bindSignInActivity(): SignInActivity
}