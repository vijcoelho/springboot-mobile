package com.api.exercicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.api.exercicio.databinding.ActivityTela3Binding

class Tela3 : AppCompatActivity() {

    private lateinit var binding: ActivityTela3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)

        binding = ActivityTela3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTela3.setOnClickListener {
            startActivity(Intent(this@Tela3, Tela2::class.java))
            finish()
        }

        binding.btnSair.setOnClickListener {
            finish()
        }
    }
}