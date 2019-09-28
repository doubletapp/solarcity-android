package com.dmentors.solar_city.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dmentors.solar_city.R
import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.presentation.signIn.SignInActivity
import com.dmentors.solar_city.utils.Preferences

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val prefs = Preferences(this)
        Handler().postDelayed({
            if (prefs.isLogin()) {
                MainActivity.start(this)
            } else {
                SignInActivity.start(this)
            }
        }, 2000)

    }
}
