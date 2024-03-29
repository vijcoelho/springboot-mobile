package com.api.test_tcc_mobile.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {

    private Retrofit retrofit;

    public RetrofitServer() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.15:9000")
                //.baseUrl("http://177.220.18.49:9000")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public UserRetrofit getAuthUser() {
        return retrofit.create(UserRetrofit.class);
    }
}

