package com.example.newsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface interApi {

    String KEY="789ab7e069cc4344824e2e3d3353ba45";

    String URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<model> getTopHeadlines(

            @Query("country") String country,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize


    );

    @GET("top-headlines")
    Call<model> getSpecific(

@Query("language") String language,
            @Query("category") String category,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize


    );

}
