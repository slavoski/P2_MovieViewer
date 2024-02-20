package com.example.p2_movieviewer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class MovieDetailFragment extends Fragment {

    final MovieData _movieData = new MovieData();
    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_view_layout, container, false);

        try {

        Movie movie = null;

        Bundle args = getArguments();

        if(args != null) {
            int movieID = args.getInt("MovieID", -1);
            if (movieID != -1) {
                movie = _movieData.getMovie(movieID);
            }
        }
        else {
            movie = _movieData.getMovie(0);
        }

        // Inflate the layout for this fragment

        TextView name = view.findViewById(R.id.movie_name);
        name.setText(movie.name);

        TextView year = view.findViewById(R.id.year);
        year.setText("Year: " + movie.year);

        TextView time = view.findViewById(R.id.running_time);
        time.setText("Runtime: " + movie.length);

        TextView director = view.findViewById(R.id.director);
        director.setText("Director: " + movie.director);

        TextView cast = view.findViewById(R.id.cast);
        cast.setText("Cast: " + movie.cast);

        TextView genre = view.findViewById(R.id.genre);
        genre.setText("Genre: " + movie.genre);

        TextView awards = view.findViewById(R.id.awards);
        awards.setText("Awards: " + movie.awards);

        TextView desc = view.findViewById(R.id.desc);
        desc.setText("Description: " + movie.desc);

        ImageView image = view.findViewById(R.id.image);
        if(movie.resource_id != -1)
        {
            image.setImageResource(movie.resource_id);
        }
        else {
            try {
                Picasso.get().load(movie.url).into(image);
            } catch (Exception ex) {
                Toast toast = Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        ViewCompat.setTransitionName(image, movie.name);

        }
        catch(Exception ex)
        {
            Toast toast = Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT);
            toast.show();
        }

        return view;

    }

}
