package com.example.newsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class home extends Fragment {

    TabLayout tabLayout;
    String q;
    TabItem general, sports, science, entertainment, health, technology;
    fragmentManager fragmentManager;
    ViewPager2 viewPager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = v.findViewById(R.id.categories);
        general = v.findViewById(R.id.general);
        sports = v.findViewById(R.id.sports);
        science = v.findViewById(R.id.science);
        entertainment = v.findViewById(R.id.entertainment);
        health = v.findViewById(R.id.health);
        technology = v.findViewById(R.id.technology);
        viewPager2 = v.findViewById(R.id.viewPager);



        fragmentManager = new fragmentManager(getChildFragmentManager(), getLifecycle());

        viewPager2.setAdapter(fragmentManager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return v;

    }
}