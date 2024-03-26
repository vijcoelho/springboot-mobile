package com.api.atividadeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.api.atividadeimc.databinding.ActivityMostrarDadosBinding

// Antonio Ilton - RA: 23505
// Vitor Coelho - RA: 23623

class MostrarDados : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val altura = bundle?.getString("altura")
        val peso = bundle?.getString("peso")
        val imc = bundle?.getDouble("imc")
        val categoriaImc = bundle?.getString("categoriaImc")

        binding.txtAltura.text = "Altura: ${altura}"
        binding.txtPeso.text = "Peso: ${peso}"
        binding.txtValorImc.text = "IMC: %.2f".format(imc)
        binding.txtCategoriaImc.text = "Situação: " + categoriaImc

        // Exibir a imagem correspondente ao IMC
        when (categoriaImc) {
            "Peso ideal" -> binding.img2.visibility = View.VISIBLE
            "Magreza grave", "Magreza moderada", "Magreza leve" -> binding.img1.visibility = View.VISIBLE
            "Sobrepeso", "Obesidade grau I", "Obesidade grau II ou severa", "Obesidade grau III ou mórbida" -> binding.img3.visibility = View.VISIBLE
        }

        binding.btnVoltar.setOnClickListener {
            startActivity(Intent(this@MostrarDados, MainActivity::class.java))
            finish()
        }
    }
}
