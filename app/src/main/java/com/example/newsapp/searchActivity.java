package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchActivity extends Fragment {

    private ArrayList<model2> data;
    private RecyclerView recyclerView;
    private adapter adapter;
    LottieAnimationView loading;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_activity, container, false);
        String api_key = "789ab7e069cc4344824e2e3d3353ba45";
        recyclerView = v.findViewById(R.id.rvsearch);
        loading=v.findViewById(R.id.loading);
        data = new ArrayList<>();
        adapter = new adapter(data, getContext());
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();

        Bundle bundle = getArguments();
        String q = bundle.getString("keyword");

        loading.setVisibility(View.VISIBLE);
        utilitiy.interApi().getKeyword("en",q,api_key,100).enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {

                if (response.isSuccessful()) {

                    loading.setVisibility(View.GONE);
                    data.addAll(response.body().getArticles());
                    if(data.size()!=0){

                        adapter.notifyDataSetChanged();
                    }


                    else{
                        Toast.makeText(getContext(), "not avialable", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });





        return v;

    }
}