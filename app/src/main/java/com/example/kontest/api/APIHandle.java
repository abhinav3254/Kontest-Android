package com.example.kontest.api;

import com.example.kontest.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
//import retrofit2.http.Query;

public class APIHandle {

    // This class serves as an entry point for interacting with the API.

    // This method returns an instance of the interface that can be used to make API calls.
    public static CallAPIInterface getAPIHandleMethod () {
        // Create an instance of the CallAPIInterface using RetrofitHelper.
        CallAPIInterface callAPIInterface = RetrofitHelper.getRetrofit().create(CallAPIInterface.class);
        return callAPIInterface;
    }

    // This inner class helps in setting up the Retrofit instance for API calls.
     public static class RetrofitHelper {
        // The base URL for the API.
        static String BASE_URL = "https://kontests.net/";

        // Create a Retrofit instance with the base URL and Gson converter factory.
        static Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Get the configured Retrofit instance.
        public static Retrofit getRetrofit() {
            return retrofit;
        }
    }

    // This interface defines the API endpoints and their associated parameters.
    public interface CallAPIInterface {

        // This method retrieves a list of Pojo objects from the API.
        // The {id} in the URL is a placeholder for the actual ID parameter.
        @GET("api/v1/{id}")
        Call<List<Pojo>> getAll(
                @Path("id") String id
        );
    }
}
