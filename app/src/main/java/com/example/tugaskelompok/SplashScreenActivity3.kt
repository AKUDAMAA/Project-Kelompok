package com.example.tugaskelompok

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen3)
        val button3: Button = findViewById(R.id.btnNext3)

        button3.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent)
            finish()
        }

    }
}