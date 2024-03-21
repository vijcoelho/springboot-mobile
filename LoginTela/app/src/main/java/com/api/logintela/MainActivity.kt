package com.api.logintela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
class MainActivity : AppCompatActivity() {
    private lateinit var buttonLogin: Button
    private lateinit var textEmail: EditText
    private lateinit var textPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.button)
        textEmail = findViewById(R.id.edtEmail)
        textPassword = findViewById(R.id.edtPassword)

        buttonLogin.setOnClickListener {
            val userEmail = textEmail.text.toString()
            val userPassword = textPassword.text.toString()

            val intent = Intent(this@MainActivity, Home::class.java).apply {
                putExtra("EMAIL", userEmail)
                putExtra("PASSWORD", userPassword)
            }
            startActivity(intent)
            finish()
        }
    }
}