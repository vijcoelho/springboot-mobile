package com.api.splashscreen.retrofit

import com.api.splashscreen.model.Classes
import com.api.splashscreen.model.UpdateClasseNameRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClassesRetrofit {
    @POST("/classes/save")
    fun saveClass(@Body classes: Classes?): Call<Classes?>?

    @get:GET("/classes/getAll")
    val allClasses: Call<List<Classes?>?>?

    @POST("/classes/updateName")
    fun updateClassName(@Body request: UpdateClasseNameRequest?): Call<Classes?>?
}