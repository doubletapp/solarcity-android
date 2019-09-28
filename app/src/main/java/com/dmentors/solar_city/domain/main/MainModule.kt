package com.dmentors.solar_city.domain.main

import com.dmentors.solar_city.base.ApiErrorHandler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainRemoteRepository(
        mainRetrofit: MainRetrofit,
        apiErrorHandler: ApiErrorHandler
    ): MainRemoteRepository =
        MainRemoteRepository(mainRetrofit, apiErrorHandler)

    @Provides
    @Singleton
    fun provideMainInteractor(mainRemoteRepository: MainRemoteRepository): MainInteractor =
        MainInteractor(mainRemoteRepository)

    @Provides
    @Singleton
    fun provideMainRetrofit(retrofit: Retrofit): MainRetrofit =
        retrofit.create(MainRetrofit::class.java)
}