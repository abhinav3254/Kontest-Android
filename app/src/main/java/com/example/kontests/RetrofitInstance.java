package com.example.kontests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    static Retrofit retrofit;

    public static Retrofit getRetrofit() {

        if(retrofit==null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://kontests.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
