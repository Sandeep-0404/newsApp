package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class modelCovid {


    public static Retrofit retrofit = null;

    public static covidInterface covidApi() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(covidInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


        }
        return retrofit.create(covidInterface.class);


    }
}