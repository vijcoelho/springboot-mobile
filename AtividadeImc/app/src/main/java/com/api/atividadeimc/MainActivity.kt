package com.api.atividadeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.api.atividadeimc.databinding.ActivityMainBinding
import com.example.model.Imc

// Antonio Ilton - RA: 23505
// Vitor Coelho - RA: 23623

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCalcular.setOnClickListener {
            val peso = binding.peso.text.toString()
            val altura = binding.altura.text.toString()

            val imc = Imc(peso.toDouble(), altura.toDouble())

            val i = Intent(this@MainActivity, MostrarDados::class.java)

            i.putExtra("peso", peso)
            i.putExtra("altura", altura)
            i.putExtra("imc", imc.calcularImc())
            i.putExtra("categoriaImc", imc.verificarImc())

            startActivity( i )
            finish()
        }
    }
}