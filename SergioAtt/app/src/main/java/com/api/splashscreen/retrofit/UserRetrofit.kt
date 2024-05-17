package com.api.splashscreen.retrofit

import com.api.splashscreen.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRetrofit {

    @POST("/user/login")
    fun authenticatorUser(@Body user: User): Call<ResponseBody>
}