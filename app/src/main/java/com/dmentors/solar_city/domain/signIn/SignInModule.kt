package com.dmentors.solar_city.domain.signIn

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SignInModule {

    @Provides
    @Singleton
    fun provideSignInInteractor(context: Context): SignInInteractor =
        SignInInteractor(context)

}