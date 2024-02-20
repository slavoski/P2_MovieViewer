package com.example.p2_movieviewer;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MovieDetailViewPager extends AppCompatActivity {
    public static class ZoomOutPageTransformer implements ViewPager2.PageTransformer {

        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();

            if(position < -1)
            {
                page.setAlpha(0f);
            }
            else if (position <= 1)
            {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
                float horizontalMargin = pageWidth *  (1 - scaleFactor) / 2;

                if(position < 0)
                {
                    page.setTranslationX(horizontalMargin - (verticalMargin / 2));
                }
                else
                {
                    page.setTranslationX(-horizontalMargin + (verticalMargin / 2));
                }

                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);

                page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            }
            else
            {
                page.setAlpha(0f);
            }
        }

    }

    ViewPagerAdapter _demoCollectionPagerAdapter;
    ViewPager2 _viewPager;

    private final MovieData _movieData = new MovieData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        _movieData.InitializeMovies();

        _demoCollectionPagerAdapter = new ViewPagerAdapter(this, _movieData);

        _viewPager = (ViewPager2) findViewById(R.id.movie_detail_pager);
        _viewPager.setAdapter(_demoCollectionPagerAdapter);
        _viewPager.setPageTransformer((ViewPager2.PageTransformer)(new ZoomOutPageTransformer()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.movie_detail_tabs);
        new TabLayoutMediator(tabLayout, _viewPager, (tab, position)
                -> tab.setText(_movieData.getItem(position).name)
        ).attach();
    }
}
