package com.dmentors.solar_city.domain.just

import com.dmentors.solar_city.base.ApiErrorHandler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class JustModule {

    @Provides
    @Singleton
    fun provideJustInteractor(justRemoteRepository: JustRemoteRepository): JustInteractor =
        JustInteractor(justRemoteRepository)

    @Provides
    @Singleton
    fun provideJustRemoteRepository(apiErrorHandler: ApiErrorHandler,
                                    justRetrofit: JustRetrofit): JustRemoteRepository =
            JustRemoteRepository(apiErrorHandler, justRetrofit)

    @Provides
    @Singleton
    fun provideJustRetrofit(retrofit: Retrofit): JustRetrofit =
            retrofit.create(JustRetrofit::class.java)
}