package com.example.p2_movieviewer;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieLibraryActivity extends AppCompatActivity implements RecyclerItemClickListener {

    private SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_library);

        RecyclerView recyclerView = findViewById(R.id.movie_library_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recyclerView.setLayoutManager(layoutManager);

        simpleRecyclerAdapter.setOnItemClickListener(this);

        recyclerView.setAdapter(simpleRecyclerAdapter);


    }

    @Override
    public void onItemClick(View v, int selected_movie) {

    }
}
