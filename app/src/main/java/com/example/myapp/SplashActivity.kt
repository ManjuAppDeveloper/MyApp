package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userName: String
    private lateinit var passWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        getLoginData()

        GlobalScope.launch {
            delay(5000)
            if (userName.isEmpty()) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            }

            finish()
        }
    }
    private fun getLoginData() {
        userName = sharedPreferences.getString("USERNAME", "")!!
        passWord = sharedPreferences.getString("PASSWORD", "")!!
    }
}
