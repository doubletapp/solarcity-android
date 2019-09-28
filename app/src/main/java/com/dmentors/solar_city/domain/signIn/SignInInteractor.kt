package com.dmentors.solar_city.domain.signIn

import android.content.Context
import com.dmentors.solar_city.utils.Preferences
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class SignInInteractor(
    context: Context
) {

    private val prefs: Preferences = Preferences(context)

    fun login(key: String) =
        Single.fromCallable {
            prefs.login()
        }
            .observeOn(Schedulers.io())

    fun isLogin() = prefs.isLogin()
}