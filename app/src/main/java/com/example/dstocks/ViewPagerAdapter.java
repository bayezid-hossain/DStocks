package com.example.dstocks;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class FragmentTitleAndFragment{
    private Fragment fragment;
    private String title;
    public FragmentTitleAndFragment(Fragment f,String title){
        this.fragment=f;
        this.title=title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }

}

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<FragmentTitleAndFragment> fragmentList=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
        return fragmentList.get(position).getTitle();
    }
    public void AddFragments(Fragment fragment,String title){
        fragmentList.add(new FragmentTitleAndFragment(fragment,title));
    }
}
