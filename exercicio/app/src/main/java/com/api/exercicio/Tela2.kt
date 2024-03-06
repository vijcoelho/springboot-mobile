package com.api.exercicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Tela2 : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        btn = findViewById(R.id.btnTela2)
        btnVoltar = findViewById(R.id.btnVoltar1)

        btn.setOnClickListener {
            startActivity(Intent(this@Tela2, Tela3::class.java))
            finish()
        }

        btnVoltar.setOnClickListener {
            startActivity(Intent(this@Tela2, MainActivity::class.java))
            finish()
        }
    }
}