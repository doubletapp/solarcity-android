package com.dmentors.solar_city.extensions

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.widget.Toast

fun Fragment.toast(text: String) = Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
fun Fragment.toast(@StringRes id: Int) = Toast.makeText(context, id, Toast.LENGTH_SHORT).show()
