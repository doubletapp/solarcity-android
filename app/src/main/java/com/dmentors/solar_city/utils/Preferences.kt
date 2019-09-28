package com.dmentors.solar_city.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    companion object {
        const val PREFERENCES_KEY = "PREFS_DM"
        const val KEY_IS_LOGIN = "islogin"
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    fun getBool(key: String, defaultValue: Boolean) = prefs.getBoolean(key, defaultValue)

    fun setBool(key: String, value: Boolean) = editor.putBoolean(key, value).commit()

    fun getInt(key: String, defaultValue: Int) = prefs.getInt(key, defaultValue)

    fun setInt(key: String, value: Int) = editor.putInt(key, value).commit()

    fun getValue(key: String, defaultValue: String) = prefs.getString(key, defaultValue) ?: ""

    fun setValue(key: String, value: String) = editor.putString(key, value).commit()

    fun isLogin(): Boolean = getBool(KEY_IS_LOGIN, false)

    fun login() = setBool(KEY_IS_LOGIN, true)
}