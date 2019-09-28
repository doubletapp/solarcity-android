package com.dmentors.solar_city.di

import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.domain.just.JustModule
import com.dmentors.solar_city.domain.main.MainModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        RetrofitCreatorModule::class, ViewModelModule::class, MainModule::class,
        JustModule::class]
)
interface ApplicationComponent : AndroidInjector<ArchApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ArchApplication>()
}