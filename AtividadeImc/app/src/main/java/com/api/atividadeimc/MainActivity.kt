package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.testeon.R
import com.example.testeon.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var txtNome: EditText
    private lateinit var txtIdade: EditText
    private lateinit var txtAltura: EditText
    private lateinit var txtPeso: EditText
    private lateinit var btnCalcular: MaterialButton
    private lateinit var txtTeste: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNome = findViewById(R.id.nome)
        txtAltura = findViewById(R.id.altura)
        txtIdade = findViewById(R.id.idade)
        txtPeso = findViewById(R.id.peso)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtTeste = findViewById(R.id.txtBemvindo)


    }

    fun calcular(view: View) {
        if (view == btnCalcular) {
            val peso = txtPeso.text.toString()
            val altura = txtAltura.text.toString()
            val idade = txtIdade.text.toString()

            txtTeste.text = peso + altura + idade
        }
    }
}