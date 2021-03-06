package com.example.android.bakingapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alessandro on 12/04/2018.
 */

public class BakingAPI {

    public static final String BAKING_URL = "https://d17h27t6h515a5.cloudfront.net/";

    public static EndPoint getRequest(){
        return new Retrofit.Builder()
                .baseUrl(BAKING_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EndPoint.class);
    }
}
