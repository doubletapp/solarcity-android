package com.dmentors.solar_city.presentation.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.signIn.SignInInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SignInViewModel(
    private val interactor: SignInInteractor
) : BaseViewModel() {

    private val mutableRegisterData = MutableLiveData<String>()
    val registerData: LiveData<String> get() = mutableRegisterData

    private val mutableSendSmsData = MutableLiveData<Boolean>()
    val sendSmsData: LiveData<Boolean> get() = mutableSendSmsData

    private val mutableLoginData = MutableLiveData<Boolean>()
    val loginData: LiveData<Boolean> get() = mutableLoginData

    fun login(code: String) {
        //TODO
        if (code == "1111") {
            addDisposable(
                interactor.login(code)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        mutableLoginData.postValue(it)
                    }, {
                        mutableError.postValue(it)
                    })
            )
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