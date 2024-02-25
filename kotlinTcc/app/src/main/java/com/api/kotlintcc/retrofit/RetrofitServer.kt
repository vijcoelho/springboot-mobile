package com.api.kotlintcc.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServer {

    private lateinit var retrofit: Retrofit

    constructor() {
        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        val gson: Gson = GsonBuilder().setLenient().create()
        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.15.15:9000")
            //.baseUrl("http://177.220.18.49:9000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }

    fun getAuthUser(): UserRetrofit {
        return retrofit.create(UserRetrofit::class.java)
    }
}