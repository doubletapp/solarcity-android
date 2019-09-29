package com.dmentors.solar_city.presentation.signIn

import androidx.lifecycle.Observer
import android.content.Context
import android.content.Intent
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import android.net.Uri
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import com.jakewharton.rxbinding2.widget.RxTextView
import com.dmentors.solar_city.extensions.toast
import com.dmentors.solar_city.presentation.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit


class SignInActivity : BaseActivity<SignInViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_sign_in

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(
                intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TOP
                )
            )
        }
    }

    override fun initViews() {

        signInRegisterBtn.setOnClickListener {
            viewModel.register()
        }
        signInShowPhoneInputBtn.setOnClickListener {
            signInBtnContainer.visibility = View.GONE
            signInPhoneContainer.visibility = View.VISIBLE
        }
        addDisposable(
            RxTextView.textChangeEvents(signInPhone)
                .debounce(
                    100,
                    TimeUnit.MILLISECONDS,
                    AndroidSchedulers.mainThread()
                )
                .subscribe { e ->
                    signInSendSmsBtn.isEnabled = !e.text().contains("_")
                }
        )

        signInPhone.setOnEditorActionListener { _, code, _ ->
            var handled = false
            if (code == EditorInfo.IME_ACTION_SEND) {
                viewModel.sendSmsTo(signInPhone.text.toString())
                handled = true
            }
            return@setOnEditorActionListener handled
        }
        signInSendSmsBtn.setOnClickListener {
            viewModel.sendSmsTo(signInPhone.text.toString())
        }
        addDisposable(
            RxTextView.textChangeEvents(signInCode)
                .debounce(
                    100,
                    TimeUnit.MILLISECONDS,
                    AndroidSchedulers.mainThread()
                )
                .subscribe { e ->
                    signInLoginBtn.isEnabled = !e.text().contains("*")
                }
        )
        signInCode.setOnEditorActionListener { _, code, _ ->
            var handled = false
            if (code == EditorInfo.IME_ACTION_SEND) {
                viewModel.login(signInCode.text.toString())
                handled = true
            }
            return@setOnEditorActionListener handled
        }
        signInLoginBtn.setOnClickListener {
            viewModel.login(signInCode.text.toString())
        }

    }

    override fun subscribeOnViewModel() {
        viewModel.error.observe(this, Observer {
            toast(it?.localizedMessage ?: "Unknown error")
        })
        viewModel.loading.observe(this, Observer {
            it?.let { loading ->
                signInProgress.visibility = if (loading) View.VISIBLE else View.GONE
            }
        })
        viewModel.registerData.observe(this, Observer {
            it?.let { url ->
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            }
        })
        viewModel.loginData.observe(this, Observer {
            when (it) {
                true -> {
                    MainActivity.start(this)
                    finish()
                }
            }
        })
        viewModel.sendSmsData.observe(this, Observer {
            when (it) {
                true -> {
                    signInCodeContainer.visibility = View.VISIBLE
                    signInPhoneContainer.visibility = View.GONE
                }
            }
        })
    }

    override fun onBackPressed() {
        when {
            signInBtnContainer.visibility == View.VISIBLE -> {
                super.onBackPressed()
            }
            signInPhoneContainer.visibility == View.VISIBLE -> {
                signInPhoneContainer.visibility = View.GONE
                signInBtnContainer.visibility = View.VISIBLE
            }
            signInCodeContainer.visibility == View.VISIBLE -> {
                signInCodeContainer.visibility = View.GONE
                signInPhoneContainer.visibility = View.VISIBLE
            }
        }
    }
}