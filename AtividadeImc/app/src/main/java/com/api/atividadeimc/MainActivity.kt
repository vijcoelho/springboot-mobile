package com.api.atividadeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.api.atividadeimc.databinding.ActivityMainBinding
import com.example.model.Imc

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun calcular(view: View) {

        if (view == binding.btnCalcular) {
            val nome = binding.nome.text.toString()
            val peso = binding.peso.text.toString()
            val altura = binding.altura.text.toString()

            val imc = Imc(peso.toDouble(), altura.toDouble())

            binding.mostrarNomeImc.text = nome + " Imc:"
            binding.mostrarImc.text = String.format("%.2f", imc.calcularImc())
            binding.nivel.text = imc.verificarImc()
        }
    }
}