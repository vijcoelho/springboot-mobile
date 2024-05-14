package com.api.splashscreen.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitServer {

    private lateinit var retrofit: Retrofit

    constructor() {
        initializerRetrofit()
    }

    private fun initializerRetrofit() {
        val gson: Gson = GsonBuilder().setLenient().create()
        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.15.15:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }

    fun getAuthUser(): UserRetrofit {
        return retrofit.create(UserRetrofit::class.java)
    }

    fun allClasses(): ClassesRetrofit {
        return retrofit.create(ClassesRetrofit::class.java)
    }
}