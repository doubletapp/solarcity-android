package com.dmentors.solar_city.presentation.main

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseNavigationActivity
import com.dmentors.solar_city.presentation.profile.ProfileFragment

class MainActivity : BaseNavigationActivity<MainViewModel>() {

    override fun getFragment(): Fragment = ProfileFragment()

    override fun getFragmentContainerId(): Int = R.id.fragment_container

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(
                intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TOP
                )
            )
        }
    }
}
