package com.soterocra.droidcafe.services;

import com.soterocra.droidcafe.entities.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("/droidcafe")
    Call<List<Products>> getProducts();
}
