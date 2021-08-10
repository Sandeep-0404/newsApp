package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.rilixtech.widget.countrycodepicker.Country;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class covid extends Fragment {
    covidClass covidClass;
    CountryCodePicker ccp;
    String countryName;
    TextView con;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_covid, container, false);
        ccp = v.findViewById(R.id.ccp);
        con=v.findViewById(R.id.textView2);
        covidClass = new covidClass();

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected(Country selectedCountry) {
               countryName=selectedCountry.getName();
            }
        });



        modelCovid.covidApi().getCovidDetails(countryName).enqueue(new Callback<com.example.newsapp.covidClass>() {
            @Override
            public void onResponse(Call<com.example.newsapp.covidClass> call, Response<com.example.newsapp.covidClass> response) {
                Log.v("sandy", response.body().getCases());

con.setText(response.body().getCases());
            }

            @Override
            public void onFailure(Call<com.example.newsapp.covidClass> call, Throwable t) {

            }
        });


        return v;
    }
}