package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class entertainment extends Fragment {

    private ArrayList<model2> data;
    private RecyclerView recyclerView;
    private adapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entertainment, container, false);
        String api_key = "789ab7e069cc4344824e2e3d3353ba45";
        recyclerView = v.findViewById(R.id.rventertainment);
        data = new ArrayList<>();
        adapter = new adapter(data, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();

        utilitiy.interApi().getSpecific("en", "entertainment", api_key, 100).enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                if (response.isSuccessful()) {

                    data.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });

        return v;
    }
}