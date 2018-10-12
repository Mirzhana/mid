package com.example.mirasyan.mid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE)

        loginBtn.setOnClickListener {
            sharedPreferences.edit().putString("login", EmailInput.text.toString()).apply()
            sharedPreferences.edit().putString("password", PasswordInput.text.toString()).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
