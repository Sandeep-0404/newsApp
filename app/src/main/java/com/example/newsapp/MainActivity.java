package com.example.newsapp;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.newsapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    Toolbar toolbar;
    TabItem general, sports, science, entertainment, health, technology;
    fragmentManager fragmentManager;
    ViewPager2 viewPager2;
    ActivityMainBinding activityMainBinding;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.categories);
        general = findViewById(R.id.general);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        entertainment = findViewById(R.id.entertainment);
        health = findViewById(R.id.health);
        technology = findViewById(R.id.technology);
        viewPager2 = findViewById(R.id.viewPager);


        fragmentManager = new fragmentManager(getSupportFragmentManager(), getLifecycle());

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


        findViewById(R.id.newsApp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(0);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}