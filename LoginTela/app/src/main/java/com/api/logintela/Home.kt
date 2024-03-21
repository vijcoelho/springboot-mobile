package com.api.logintela

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Home : AppCompatActivity() {
    private lateinit var buttonBack: Button
    private lateinit var buttonExit: Button
    private lateinit var txtInformacao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        buttonBack = findViewById(R.id.btnVoltar)
        buttonExit = findViewById(R.id.btnSair)
        txtInformacao = findViewById(R.id.txtInfo)

        val userEmail = intent.getStringExtra("EMAIL")
        val userPassword = intent.getStringExtra("PASSWORD")

        txtInformacao.text = "Email: " + userEmail + "\n" +
                             "Password: " + userPassword

        buttonBack.setOnClickListener {
            startActivity(Intent(this@Home, MainActivity::class.java))
            finish()
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}