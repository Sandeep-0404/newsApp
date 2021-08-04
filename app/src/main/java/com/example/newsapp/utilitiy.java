package com.example.newsapp;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class utilitiy {

    public static Retrofit retrofit=null;

    public static interApi interApi(){

        if(retrofit==null){

            retrofit=new Retrofit.Builder().baseUrl(interApi.URL).addConverterFactory(GsonConverterFactory.create()).build();


        }
        return retrofit.create(interApi.class);


    }
}
