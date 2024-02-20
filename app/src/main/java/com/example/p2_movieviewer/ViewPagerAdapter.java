package com.example.p2_movieviewer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    MovieData _movieData;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, MovieData movieData )
    {
        super(fragmentActivity);
        _movieData = movieData;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt("MovieID", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getItemCount() {
        return _movieData.getMoviesSize();
    }
}
