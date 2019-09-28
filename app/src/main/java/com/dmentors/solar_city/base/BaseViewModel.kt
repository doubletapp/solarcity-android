package com.dmentors.solar_city.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.annotation.CallSuper
import io.reactivex.SingleTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    protected val mutableLoading = MutableLiveData<Boolean>()
    protected val mutableError = MutableLiveData<Throwable>()

    val loading: LiveData<Boolean> get() = mutableLoading
    val error: LiveData<Throwable> get() = mutableError

    protected fun addDisposable(disposable: Disposable) = disposables.add(disposable)
    protected fun addDisposables(vararg disposable: Disposable) = disposables.addAll(*disposable)
    protected fun removeDisposable(disposable: Disposable) = disposables.remove(disposable)

    protected fun <T> viewModelCompose(): SingleTransformer<T, T> =
        SingleTransformer {
            it.doOnSubscribe { mutableLoading.postValue(true) }
                .doOnError { throwable ->
                    mutableError.postValue(throwable)
                }
                .doFinally { mutableLoading.postValue(false) }
        }


    @CallSuper
    override fun onCleared() = disposables.clear()
}