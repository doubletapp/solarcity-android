package com.dmentors.solar_city.base

import android.content.SharedPreferences

class AuthorizationKeyValueStorage(private val sharedPreferences: SharedPreferences) {

    private fun putString(key: String, value: String) =
            sharedPreferences
                    .edit()
                    .putString(key, value)
                    .apply()

    private fun getString(key: String): String? = sharedPreferences.getString(key, null)

    private fun putBoolean(key: String, value: Boolean) =
            sharedPreferences
                    .edit()
                    .putBoolean(key, value)
                    .apply()

    private fun getBoolean(key: String, defValue: Boolean): Boolean =
            sharedPreferences.getBoolean(key, defValue)

    fun clear() = sharedPreferences.edit().clear().apply()

    companion object {

        const val AUTHORIZATION_DATA = "authorization_data"

    }
}