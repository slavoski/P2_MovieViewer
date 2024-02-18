package com.example.p2_movieviewer;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

public class MasterDetail extends AppCompatActivity implements RecyclerItemClickListener {

    private boolean twoPane;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_detail);
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new MovieListFragment()).commit();
        }
        twoPane = false;

        if(findViewById(R.id.detail_container) != null)
        {
            twoPane = true;
        }
    }

    @Override
    public void onItemClick(View v, int id) {
        Bundle args = new Bundle();
        args.putInt("MovieID", id);
        //args.putInt("img_id", selectedMovie.resource_id);
        //args.putString("name", selectedMovie.name);
        //args.putString("year", selectedMovie.year);
        //args.putString("runtime", selectedMovie.length);
        //args.putString("director", selectedMovie.director);
        //args.putString("cast", selectedMovie.cast);
        //args.putString("genre", selectedMovie.genre);
        //args.putString("awards", selectedMovie.awards);
        //args.putString("description", selectedMovie.desc);

        Fragment detailFragment = new MovieDetailFragment();
        detailFragment.setArguments(args);

        if(twoPane)
        {
            detailFragment.setEnterTransition(new Slide(Gravity.TOP));
            detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, detailFragment)
                    .addToBackStack(null).commit();
        }
        else
        {

            getSupportFragmentManager().beginTransaction()

                    .replace(R.id.main_container, detailFragment)
                    .addToBackStack(null).commit();
        }

    }
}
