package com.example.p2_movieviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;


public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {

    final List<Movie> movie_list;
    RecyclerItemClickListener recyclerListener = null;
    ViewHolder viewHolder = null;

    public SimpleRecyclerAdapter(){
        movie_list = new MovieData().getMoviesList();
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
        Movie movie = movie_list.get(position);
        holder.movie_name.setText(movie.name);
        holder.movie_year.setText(movie.year);

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
        return movie_list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final public TextView movie_name;
        final public TextView movie_year;
        final public ImageView poster_img;

        public ViewHolder(View view) {
            super(view);
            movie_name = view.findViewById(R.id.movie_name);
            movie_year = view.findViewById(R.id.movie_year);
            poster_img = view.findViewById(R.id.poster_photo);
        }
    }
}
