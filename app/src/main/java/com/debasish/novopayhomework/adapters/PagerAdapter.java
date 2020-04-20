package com.debasish.novopayhomework.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.debasish.novopayhomework.fragments.EverythingFragment;
import com.debasish.novopayhomework.fragments.SourcesFragment;
import com.debasish.novopayhomework.fragments.TopHeadlinesFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopHeadlinesFragment();
            case 1:
                return new EverythingFragment();
            case 2:
                return new SourcesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
