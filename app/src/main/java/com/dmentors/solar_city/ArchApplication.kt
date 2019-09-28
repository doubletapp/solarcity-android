package com.dmentors.solar_city

import com.dmentors.solar_city.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ArchApplication : DaggerApplication() {

    companion object {
        var appContext: ArchApplication? = null
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}