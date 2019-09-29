package com.dmentors.solar_city.domain.chat

import com.dmentors.solar_city.presentation.chat.Message
import io.reactivex.schedulers.Schedulers
import java.lang.IllegalStateException

class ChatInteractor(private val chatRetrofit: ChatRetrofit) {

    fun sendMessage(message: String) =
        chatRetrofit.sendMessage(MessageRequest(message))
            .map {
                if (it.message != null) {
                    return@map it
                } else {
                    throw IllegalStateException()
                }
            }
            .map { return@map it.apply { type = Message.Type.FOREIGN } }
            .subscribeOn(Schedulers.io())
}