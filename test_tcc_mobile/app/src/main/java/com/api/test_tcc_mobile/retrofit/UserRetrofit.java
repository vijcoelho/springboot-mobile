package com.api.test_tcc_mobile.retrofit;

import com.api.test_tcc_mobile.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRetrofit {

    @POST("/login")
    Call<String> authenticateUser(@Body User user);
}
