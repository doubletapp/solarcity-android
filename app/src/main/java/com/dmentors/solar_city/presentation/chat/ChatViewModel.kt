package com.dmentors.solar_city.presentation.chat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.chat.ChatInteractor

class ChatViewModel(
    private val chatInteractor: ChatInteractor
) : BaseViewModel() {

    private val mutableMessage = MutableLiveData<Message?>()

    val message: LiveData<Message?> get() = mutableMessage

    fun sendMessage(message: String) =
        chatInteractor.sendMessage(message)
            .subscribe({ mutableMessage.postValue(it) },
                { Log.e("ChatViewModel", "sendMessage()", it) })
}