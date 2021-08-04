package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragmentManager extends FragmentStateAdapter {


    public fragmentManager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){

            case 0:
            return new general();

            case 1:
                return new sports();

            case 2:
                return new science();

            case 3:
                return new entertainment();

            case 4:
                return new health();

            case 5:
                return new technology();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
