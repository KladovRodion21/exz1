package com.example.exp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog



class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.txtEmail)
        pass = findViewById(R.id.txtPass)
    }

    fun login(view: android.view.View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)

    }
    }
