package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextUsername: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var next_button: Button
    private lateinit var cancel_button: Button
    private lateinit var userName: String
    private lateinit var passWord: String
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        onClicks()
        sharedPreferences=getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)
    }
    private fun onClicks() {
        next_button.setOnClickListener() {
            userName = editTextUsername.text.toString()
            passWord = editTextPassword.text.toString()
            saveLoginData(userName,passWord)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        cancel_button.setOnClickListener() {
            editTextUsername.text?.clear()
            editTextPassword.text?.clear()
        }
    }
    private fun saveLoginData(userName: String, passWord: String) {
        val editor =sharedPreferences.edit()
        editor.putString("USERNAME",userName)
        editor.putString("PASSWORD",passWord)
        editor.apply()
    }
    private fun initViews() {
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        next_button = findViewById(R.id.next_button)
        cancel_button = findViewById(R.id.cancel_button)
    }
}