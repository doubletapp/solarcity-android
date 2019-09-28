package com.dmentors.solar_city.extensions

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity

fun DaggerAppCompatActivity.toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
fun DaggerAppCompatActivity.toast(@StringRes id: Int) = Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

fun DaggerAppCompatActivity.showFragment(container: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         addToBackStack: Boolean) {
    if (this.supportFragmentManager.findFragmentByTag(tag) == null) {
        if (addToBackStack) {
            this.supportFragmentManager
                .beginTransaction()
                .replace(container, fragment, tag)
                .addToBackStack(tag)
                .commit()
        } else {
            this.supportFragmentManager
                .beginTransaction()
                .replace(container, fragment, tag)
                .commit()
        }
    }
}