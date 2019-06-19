package com.anhtam.tikihome.services;

import com.anhtam.tikihome.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("tikivn/android-home-test/v3/products.json")
    Call<List<Product>> getListProduct ();
}
