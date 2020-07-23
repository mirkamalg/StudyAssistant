package com.mirkamal.studyassistant.ui.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.mirkamal.studyassistant.R;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private SmoothBottomBar bottomBar;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        configureViewPager();

        bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                viewPager.setCurrentItem(i);

                return true;
            }
        });
    }

    private void initializeUI() {
        bottomBar = findViewById(R.id.bottom_bar);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setUserInputEnabled(false);
    }

    private void configureViewPager() {
        MainPagerAdapter adapter = new MainPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}