package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface covidInterface {

    String BASE_URL="https://disease.sh/v3/covid-19/";

    @GET ("countries/{country}")
    Call<covidClass> getCovidDetails (

      @Path("country") String country

    );
}
