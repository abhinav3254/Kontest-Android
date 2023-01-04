package com.example.kontest.api;

import com.example.kontest.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class APIHandle {

    public static CallAPIInterface getAPIHandleMethod () {
        CallAPIInterface callAPIInterface = RetrofitHelper.getRetrofit().create(CallAPIInterface.class);
        return callAPIInterface;
    }

     public static class RetrofitHelper {
        static String BASE_URL = "https://kontests.net/";
        static Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        public static Retrofit getRetrofit() {
            return retrofit;
        }
    }

    public interface CallAPIInterface {
        @GET("api/v1/{id}")
        Call<List<Pojo>> getAll(
                @Path("id") String id
        );
    }
}
