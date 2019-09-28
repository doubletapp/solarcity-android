package com.dmentors.solar_city.di

import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.domain.base.DatabaseModule
import com.dmentors.solar_city.domain.calendar.CalendarModule
import com.dmentors.solar_city.domain.just.JustModule
import com.dmentors.solar_city.domain.main.MainModule
import com.dmentors.solar_city.domain.signIn.SignInModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        RetrofitCreatorModule::class, ViewModelModule::class, MainModule::class,
        RetrofitModule::class, InteractorModule::class, SignInModule::class, CalendarModule::class, DatabaseModule::class]
)
interface ApplicationComponent : AndroidInjector<ArchApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ArchApplication>()
}