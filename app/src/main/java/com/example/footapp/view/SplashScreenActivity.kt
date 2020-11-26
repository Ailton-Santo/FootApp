package com.example.footapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.footapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        scheduleSplashScreen()

    }

    private fun scheduleSplashScreen() {

        val splashScreenDuration = 3500L
        Handler().postDelayed(
            {

                val showLoginScreen = Intent(this, LoginActivity::class.java)
                startActivity(showLoginScreen)
                finish()
            },
            splashScreenDuration
        )
    }
}
