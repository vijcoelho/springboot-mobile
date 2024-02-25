package com.api.kotlintcc.retrofit

import com.api.kotlintcc.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserRetrofit {

    @POST("/login")
    fun authenticatorUser(@Body user: User): Call<ResponseBody>

    @GET("/get-current-user")
    fun getCurrentUser(): Call<User>
}