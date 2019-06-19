package com.anhtam.tikihome.services;

import com.anhtam.tikihome.config.Config;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static ApiClient instanse;
    private Retrofit retrofit;

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL_API_PRODUCT)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstanse() {
        if (instanse == null)
            instanse = new ApiClient();
        return instanse;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.writeTimeoutMillis();
        httpClient.readTimeoutMillis();
        return httpClient;
    }
}
