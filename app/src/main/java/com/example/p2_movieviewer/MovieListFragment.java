package com.example.p2_movieviewer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MovieListFragment extends Fragment {

    RecyclerItemClickListener clickListener;

    private final SimpleRecyclerAdapter myRecyclerAdapter = new SimpleRecyclerAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.movie_library_recycler);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
                clickListener=(RecyclerItemClickListener) context;
                myRecyclerAdapter.setOnItemClickListener(clickListener);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
