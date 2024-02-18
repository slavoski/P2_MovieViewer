package com.example.p2_movieviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;


public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {

    final MovieData movies;
    RecyclerItemClickListener recyclerListener = null;
    ViewHolder viewHolder = null;

    public SimpleRecyclerAdapter(){
        movies = new MovieData();
        movies.InitializeMovies();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_layout, parent, false);
        viewHolder = new ViewHolder(view);

        view.setOnClickListener(this::onMenuItemClick);

        return viewHolder;
    }

    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener)
    {
        recyclerListener = recyclerItemClickListener;
    }

    public void onMenuItemClick(View view) {
       if(recyclerListener != null)
       {
           recyclerListener.onItemClick(view, viewHolder.getAdapterPosition());
       }
    }


    @Override
    public void onBindViewHolder(@NonNull SimpleRecyclerAdapter.ViewHolder holder, int position) {
        Movie movie = movies.getItem(position);
        holder.movie_year.setText(movie.year);

        ViewCompat.setTransitionName(holder.poster_img, movie.name);

        if(movie.resource_id != -1)
        {
            holder.poster_img.setImageResource(movie.resource_id);
        }
        else {
            try {

                Picasso.get().load(movie.url).into(holder.poster_img);
            } catch (Exception e) {
                e.toString();
            }
        }

    }



    @Override
    public int getItemCount() {
        return movies.getMoviesSize();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final public TextView movie_year;
        final public ImageView poster_img;

        public ViewHolder(View view) {
            super(view);
            movie_year = view.findViewById(R.id.movie_year);
            poster_img = view.findViewById(R.id.poster_photo);
        }
    }
}
