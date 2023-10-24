package com.example.tugaskelompok

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email"
        const val PASSWORD_KEY = "password"
    }

    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login3)

        val inputUsername: EditText = findViewById(R.id.inputUsername)
        val inputPassword: TextInputEditText = findViewById(R.id.inputPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnSignup: TextView = findViewById(R.id.btnSignUp)

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val enteredUsername = inputUsername.text.toString()
            val enteredPassword = inputPassword.text.toString()

            // Ambil data pengguna terdaftar dari SharedPreferences
            val storedPassword = sharedPreferences.getString(enteredUsername, "")

            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please input username and password", Toast.LENGTH_LONG).show()
            } else if (storedPassword == enteredPassword) {
                // Berhasil masuk, Anda dapat mengarahkan pengguna ke aktivitas lain
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Username atau kata sandi salah, tampilkan pesan kesalahan
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_LONG).show()
            }
        }

        btnSignup.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
