package com.example.p2_movieviewer;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieLibraryActivity extends AppCompatActivity implements RecyclerItemClickListener {

    private RecyclerView recyclerView;
    private SimpleRecyclerAdapter simpleRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_library);

        recyclerView = (RecyclerView) findViewById(R.id.movie_library_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recyclerView.setLayoutManager(layoutManager);

        simpleRecyclerAdapter = new SimpleRecyclerAdapter();
        simpleRecyclerAdapter.setOnItemClickListener(this);

        recyclerView.setAdapter(simpleRecyclerAdapter);


    }

    @Override
    public void onItemClick(View v, int position) {

    }
}
