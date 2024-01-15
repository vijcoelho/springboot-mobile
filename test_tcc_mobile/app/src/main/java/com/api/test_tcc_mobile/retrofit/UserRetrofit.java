package com.api.test_tcc_mobile.retrofit;

import com.api.test_tcc_mobile.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserRetrofit {

    @POST("/login")
    Call<ResponseBody> authenticateUser(@Body User user);

    @GET("/get-current-user")
    Call<User> getCurrentUser();
}
