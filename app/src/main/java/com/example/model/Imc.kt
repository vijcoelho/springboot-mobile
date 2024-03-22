package com.example.model

class Imc(){

    private var idade: Int = 0
    private var altura: Double = 0.0
    private var peso: Double = 0.0

    constructor(peso: Double, altura: Double, idade: Int): this() {
        this.peso = peso
        this.altura = altura
        this.idade = idade
    }

    fun calcularImc(imc: Imc): Double {
        return (this.peso / (this.altura * 2))
    }
}





