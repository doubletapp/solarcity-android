package com.dmentors.solar_city.base

import androidx.annotation.StringRes
import android.widget.Toast
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel> : DaggerFragment() {

    protected val disposables = CompositeDisposable()

    @Inject
    lateinit var viewModel: T

    fun showToast(@StringRes resourceId: Int) =
        context?.let { Toast.makeText(it, resourceId, Toast.LENGTH_LONG).show() }

    fun showToast(text: String) =
        context?.let { Toast.makeText(it, text, Toast.LENGTH_LONG).show() }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}