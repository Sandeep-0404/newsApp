package com.example.newsapp;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {
    int home = 1;
    int covid = 2;
    int weather = 3;
    TabLayout tabLayout;
    String q;
    Toolbar toolbar;
    ChipNavigationBar chipNavigationBar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


        chipNavigationBar = findViewById(R.id.chip);
        chipNavigationBar.setItemSelected(R.id.home, true);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new home()).commit();


        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new home();
                        break;

                    case R.id.covid:
                        fragment = new covid();
                        break;

                    case R.id.weather:
                        fragment = new weather();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Search here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Toast.makeText(MainActivity.this, "hey", Toast.LENGTH_SHORT).show();

                if (searchView.getQuery() != null) {

                    q = searchView.getQuery().toString().trim().toLowerCase();

                    //viewPager2.setCurrentItem(0);
                    Toast.makeText(getApplicationContext(), q, Toast.LENGTH_SHORT).show();
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


}