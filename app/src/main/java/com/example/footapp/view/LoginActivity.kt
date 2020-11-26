package com.example.footapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.footapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun displayCompetitionsScreen(view: View) {
        val showTeamScreen = Intent(this, CompetitionActivity::class.java)
        startActivity(showTeamScreen)
        finish()
    }
}