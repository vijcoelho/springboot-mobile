package com.example.testeon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "Ciclo de Vida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Chamado")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Chamado")
    }
}