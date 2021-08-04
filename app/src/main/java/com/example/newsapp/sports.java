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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sports#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sports extends Fragment {

    private ArrayList<model2> data;
    private RecyclerView recyclerView;
    private adapter adapter;
    private ArrayList<model2> datalist;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sports() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sports.
     */
    // TODO: Rename and change types and number of parameters
    public static sports newInstance(String param1, String param2) {
        sports fragment = new sports();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sports, container, false);
        String api_key = "789ab7e069cc4344824e2e3d3353ba45";
        recyclerView = v.findViewById(R.id.rvsports);
        datalist = new ArrayList<>();
        data = new ArrayList<>();
        adapter = new adapter(data, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();

        utilitiy.interApi().getSpecific("en", "sports", api_key, 100).enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                if (response.isSuccessful()) {

                    data.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
//d
                }
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });

        return v;
    }
}