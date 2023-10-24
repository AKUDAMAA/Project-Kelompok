package com.example.tugaskelompok

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.aplikasistoragesqlite.db.DBHelper

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        var inputName: EditText = findViewById(R.id.enterName)
        var inputPass: EditText = findViewById(R.id.enterPassword)
        var btnLogin2: Button = findViewById(R.id.btnLogin2)
        btnLogin2.setOnClickListener {
            val db = DBHelper(this, null)
            val username = inputName.text.toString()
            val password = inputPass.text.toString()

            // Cek apakah nama sudah digunakan sebelumnya
            if (isNameAlreadyUsed(db, username)) {
                Toast.makeText(this, "Username sudah digunakan", Toast.LENGTH_LONG).show()
            } else {
                // Jika nama belum digunakan, tambahkan ke database
                db.addName(username, password)
                Toast.makeText(this, "Data ditambahkan ke database", Toast.LENGTH_LONG).show()
                inputName.text.clear()
                inputPass.text.clear()
            }

            // Simpan data pengguna saat mendaftar
            val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(username, password)  // Gunakan username sebagai kunci
            editor.apply()

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }







    }

    @SuppressLint("Range")
    private fun isNameAlreadyUsed(db: DBHelper, name: String): Boolean {
        val cursor = db.getName()
        var nameUsed = false

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val storedName = cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL))
                    if (name == storedName) {
                        nameUsed = true
                        break
                    }
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        return nameUsed
    }
}