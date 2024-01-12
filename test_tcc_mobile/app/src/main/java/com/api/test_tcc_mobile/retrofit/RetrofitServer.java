package com.api.test_tcc_mobile.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitServer {

    private Retrofit retrofit;

    public RetrofitServer() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.15:9000")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    public UserRetrofit getAuthUser() {
        return retrofit.create(UserRetrofit.class);
    }
}

