package com.example.vehiclehmi;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;



import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter FragmentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout =  findViewById(R.id.tabLayout);
        viewPager2 =  findViewById(R.id.viewPager2);
        FragmentManager fm = getSupportFragmentManager();

        FragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(FragmentAdapter);


        tabLayout.addTab(tabLayout.newTab().setText("Controls"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}