package com.example.kontests;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APInterface {

    @GET("api/v1/all")
    Call<List<Pojo>> getAll(
    );

    @GET("api/v1/{all}")
    Call<List<Pojo>> getSpecific(
            @Path("all") String path
    );

}
