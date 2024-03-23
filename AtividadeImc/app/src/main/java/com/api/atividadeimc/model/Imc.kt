package com.example.model

class Imc(){

    private var altura: Double = 0.0
    private var peso: Double = 0.0

    constructor(peso: Double, altura: Double): this() {
        this.peso = peso
        this.altura = altura
    }

    fun calcularImc(): Double {
        return (this.peso / (this.altura * this.altura))
    }

    fun verificarImc(): String {
        val imc = calcularImc()
        return when {
            imc < 16 -> "Magreza grave"
            imc in 16.0..16.9 -> "Magreza moderada"
            imc in 17.0..18.5 -> "Magreza leve"
            imc in 18.6..24.9 -> "Peso ideal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidade grau I"
            imc in 35.0..39.9 -> "Obesidade grau II ou severa"
            else -> "Obesidade grau III ou mórbida"
        }
    }
}





