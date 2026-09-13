package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private val validUsername = "admin"
    private val validPassword = "password123"

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val enteredUsername = etUsername.text.toString().trim()
            val enteredPassword = etPassword.text.toString().trim()


            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if (enteredUsername == validUsername && enteredPassword == validPassword) {

                Toast.makeText(
                    this,
                    "Welcome, $enteredUsername!",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                Toast.makeText(
                    this,
                    "Invalid username or password. Please try again.",
                    Toast.LENGTH_LONG
                ).show()
                etUsername.text.clear()
                etPassword.text.clear()
                etUsername.requestFocus()
            }
        }
    }
}