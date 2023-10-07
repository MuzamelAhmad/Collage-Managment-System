package com.example.myapplication.Fregments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.Adopter.ViewPagerHomeAdapter;
import com.google.android.material.tabs.TabLayout;

public class Home extends Fragment {
    TabLayout tabs;
    ViewPager viewPager;


    public Home() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tabs = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);

        ViewPagerHomeAdapter adapter;
        adapter = new ViewPagerHomeAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);



        setupOnBackPressed();
        return view;
    }

    private void setupOnBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(isEnabled())
                {
                    Toast.makeText(requireContext(),"Go Back",Toast.LENGTH_SHORT).show();
                    setEnabled(false);
                    requireActivity().onBackPressed();

                }
            }
        });
    }
}
