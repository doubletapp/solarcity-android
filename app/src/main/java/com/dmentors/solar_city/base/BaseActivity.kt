package com.dmentors.solar_city.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : DaggerAppCompatActivity() {

    protected val disposables = CompositeDisposable()
    protected abstract fun getLayoutId(): Int

    @Inject
    lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViews()
        subscribeOnViewModel()
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    open fun initViews() {

    }

    open fun subscribeOnViewModel() {

    }

    protected fun addDisposable(disposable: Disposable) = disposables.add(disposable)
}