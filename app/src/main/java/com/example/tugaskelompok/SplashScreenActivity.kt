package com.example.tugaskelompok

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.btnNext1)

        button1.setOnClickListener {
            val intent = Intent(this, SplashScreenActivity2::class.java)

            // Terapkan animasi
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)


            startActivity(intent)
            finish()
        }
    }
}
