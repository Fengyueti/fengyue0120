package com.example.lenovo.fengyue0120.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.fengyue0120.R;
import com.example.lenovo.fengyue0120.fragment.FragmentOne;
import com.example.lenovo.fengyue0120.fragment.FragmentTwo;

public class Main3Activity extends AppCompatActivity {

    private ViewPager viewpager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   viewpager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewpager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewpager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        viewpager =findViewById(R.id.viewpager);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new FragmentTwo();
                    case 1:
                        return new FragmentOne();
                    case 2:
                        return new FragmentTwo();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
