package com.dmentors.solar_city.di

import android.content.Context
import android.content.SharedPreferences
import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.base.AuthorizationKeyValueStorage
import com.dmentors.solar_city.di.activity.ActivityBindingModule
import com.dmentors.solar_city.di.fragment.FragmentBindingModule
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton



@Module(includes = [ActivityBindingModule::class, FragmentBindingModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: ArchApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideAuthorizationKeyValueStorage(@Named(AuthorizationKeyValueStorage.AUTHORIZATION_DATA) sharedPreferences: SharedPreferences)
            : AuthorizationKeyValueStorage =
        AuthorizationKeyValueStorage(sharedPreferences)

    @Provides
    @Singleton
    @Named(AuthorizationKeyValueStorage.AUTHORIZATION_DATA)
    fun provideAuthorizationSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(AuthorizationKeyValueStorage.AUTHORIZATION_DATA, Context.MODE_PRIVATE)
}