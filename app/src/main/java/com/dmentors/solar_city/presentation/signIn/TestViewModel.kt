package com.dmentors.solar_city.presentation.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.signIn.SignInInteractor
import io.reactivex.android.schedulers.AndroidSchedulers

class TestViewModel(
    private val interactor: SignInInteractor
) : BaseViewModel() {

    private val mutableLoginData = MutableLiveData<Boolean>()
    val loginData: LiveData<Boolean> get() = mutableLoginData

    fun login(code: String) {
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
        }
    }

}