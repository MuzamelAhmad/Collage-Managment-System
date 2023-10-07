package com.example.myapplication.Adopter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Fregments.About_asFragment;
import com.example.myapplication.Fregments.LocationFragment;
import com.example.myapplication.Fregments.our_viewFragment;

/** @noinspection ALL, deprecation */
public class ViewPagerHomeAdapter extends FragmentPagerAdapter {


    /** @noinspection deprecation*/
    public ViewPagerHomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
           return new our_viewFragment();
        }
        else if (position==1)
        {
            return new LocationFragment();
        }
        else {
            return new About_asFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
        {
            return "Our View";
        }
        else if (position==1)
        {
            return "Location";
        }
        else
        {
            return "Contact & About As";
        }
    }
}
