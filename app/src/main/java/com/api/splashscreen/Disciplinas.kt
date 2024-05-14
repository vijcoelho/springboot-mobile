package com.api.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.api.splashscreen.databinding.ActivityDisciplinasBinding
import com.api.splashscreen.retrofit.RetrofitServer

class Disciplinas : AppCompatActivity() {

    private lateinit var retrofitServer: RetrofitServer
    private lateinit var binding: ActivityDisciplinasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplinas)

        binding = ActivityDisciplinasBinding.inflate(layoutInflater)
        setContentView(binding.recyclerView)

    }

    private fun loadClasses() {
        val call = retrofitServer.allClasses()
    }
}