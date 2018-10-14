package com.example.rehmasan.ksuhelp;
/*use tab layout to handle anything tab related*/
import android.support.design.widget.TabLayout;
import android.graphics.Matrix;

import android.support.v4.view.ScaleGestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);

        /*references the category adapter script to make a new adapter*/
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());


        if (viewPager != null)
        {
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(CategoryAdapter.NUM_PAGE_FRAGS - 1);
        }

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }

    }

}