package com.dmentors.solar_city.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dmentors.solar_city.R
import com.dmentors.solar_city.presentation.signIn.SignInActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed( { SignInActivity.start(this) }, 2000)
    }
}
