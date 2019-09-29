package com.dmentors.solar_city.di

import com.dmentors.solar_city.domain.chat.ChatInteractor
import com.dmentors.solar_city.domain.chat.ChatRetrofit
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideChatInteractor(chatRetrofit: ChatRetrofit) = ChatInteractor(chatRetrofit)
}