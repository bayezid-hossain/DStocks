package com.example.dstocks;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomePage extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        appBarLayout=findViewById(R.id.appbar_id);
        viewPager=findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragments(new companiesFragment(),"");
        adapter.AddFragments(new portfolioFragment(),"");
        adapter.AddFragments(new homeFragment(),"");
        adapter.AddFragments(new favoriteFragment(),"");
        adapter.AddFragments(new settingsFragment(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.companies_icon);

        tabLayout.getTabAt(1).setIcon(R.drawable.portfolio);
        tabLayout.getTabAt(2).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.favorite_icon);
        tabLayout.getTabAt(4).setIcon(R.drawable.settings);
        tabLayout.getTabAt(2).select();
    }
}
