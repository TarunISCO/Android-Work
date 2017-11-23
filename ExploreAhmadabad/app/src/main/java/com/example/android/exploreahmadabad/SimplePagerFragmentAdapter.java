package com.example.android.exploreahmadabad;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static java.security.AccessController.getContext;

/**
 * Created by tarun on 24/6/17.
 */

public class SimplePagerFragmentAdapter extends FragmentPagerAdapter {

    ;
    private String tabTitles[] = new String[] {"Visits", "Dine", "Shopping", "Stay"};

    public SimplePagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VisitFragment();
        } else if (position == 1){
            return new FoodFragment();
        } else if (position == 2) {
            return new ShopFragment();
        } else {
            return new HotelFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
