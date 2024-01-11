package com.api.test_tcc_mobile.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {

    private Retrofit retrofit;

    public RetrofitServer() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.15:9000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public UserRetrofit getAuthUser() {
        return retrofit.create(UserRetrofit.class);
    }
}
