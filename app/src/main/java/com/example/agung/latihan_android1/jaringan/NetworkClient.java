package com.example.agung.latihan_android1.jaringan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by agung on 24/12/17.
 */

public class NetworkClient {

    public static Retrofit client(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
