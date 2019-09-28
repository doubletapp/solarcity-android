package com.dmentors.solar_city.presentation.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseViewModel
import javax.inject.Inject

class SignInViewModel
@Inject
constructor() : BaseViewModel() {

    private val mutableRegisterData = MutableLiveData<String>()
    val registerData: LiveData<String> get() = mutableRegisterData

    private val mutableSendSmsData = MutableLiveData<Boolean>()
    val sendSmsData: LiveData<Boolean> get() = mutableSendSmsData

    private val mutableLoginData = MutableLiveData<Boolean>()
    val loginData: LiveData<Boolean> get() = mutableLoginData

    fun login(code: String) {
        //TODO
        if (code == "1111") {
            mutableLoginData.postValue(true)
        } else {
            mutableError.postValue(Throwable(ArchApplication.appContext?.getString(R.string.sign_in_wrong_code)))
        }
    }

    fun register() {
        mutableRegisterData.postValue("https://www.sgdeti.ru/projects/nastavnichiestvo")
    }

    fun sendSmsTo(phone: String) {
        //TODO
        mutableSendSmsData.postValue(true)
    }
}