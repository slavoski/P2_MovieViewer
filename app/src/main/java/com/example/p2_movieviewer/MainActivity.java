package com.example.p2_movieviewer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.p2_movieviewer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final MainActivityViewModel data = new MainActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        com.example.p2_movieviewer.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Toolbar newToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(newToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);


        return super.onCreateOptionsMenu(menu);
    }


}