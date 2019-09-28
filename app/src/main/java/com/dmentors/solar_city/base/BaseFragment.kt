package com.dmentors.solar_city.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import android.widget.Toast
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel> : DaggerFragment() {

    protected val disposables = CompositeDisposable()

    protected abstract fun getLayoutId(): Int

    @Inject
    lateinit var viewModel: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeToViewModel()
    }

    protected open fun subscribeToViewModel() {

    }

    protected open fun initViews() {

    }

    fun showToast(@StringRes resourceId: Int) =
        context?.let { Toast.makeText(it, resourceId, Toast.LENGTH_LONG).show() }

    fun showToast(text: String) =
        context?.let { Toast.makeText(it, text, Toast.LENGTH_LONG).show() }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}