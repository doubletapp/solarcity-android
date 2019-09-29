package com.dmentors.solar_city.domain.chat

import com.dmentors.solar_city.presentation.chat.Message
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ChatRetrofit {

    @POST("chat/post/")
    fun sendMessage(@Body message: MessageRequest): Single<Message>
}