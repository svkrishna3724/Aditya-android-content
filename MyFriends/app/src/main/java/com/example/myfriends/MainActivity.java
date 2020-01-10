package com.example.myfriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.viewpager);
        tl = findViewById(R.id.tablayout);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(vpa);
        tl.setupWithViewPager(vp);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Best Friend";
                case 1:
                    return "Good Friend";
                case 2:
                    return "Friend";
            }
            return super.getPageTitle(position);
        }

        public ViewPagerAdapter(@NonNull FragmentManager fm)
        {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new RedFragment();
                case 1:
                    return new BlueFragment();
                case 2:
                    return new GreenFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
