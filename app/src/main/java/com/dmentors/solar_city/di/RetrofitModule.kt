package com.dmentors.solar_city.di

import com.dmentors.solar_city.domain.chat.ChatRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RetrofitModule {

    @Provides
    fun provideChatRetrofit(retrofit: Retrofit) = retrofit.create(ChatRetrofit::class.java)
}