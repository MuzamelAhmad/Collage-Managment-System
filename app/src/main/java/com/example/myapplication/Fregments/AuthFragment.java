package com.example.myapplication.Fregments;


import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Emailotpsetter;
import com.example.myapplication.R;


public class AuthFragment extends Fragment {
    ConstraintLayout e1,sms;


    public AuthFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "Welcome to OTP ", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_auth, container, false);

        e1 = view.findViewById(R.id.Email_otp);
        sms = view.findViewById(R.id.phone_otp);



        e1.setOnClickListener(view1 -> {

            Intent intent = new Intent(getActivity(), Emailotpsetter.class);
            startActivity(intent);
        });
        sms.setOnClickListener(view12 -> {

            Intent intent = new Intent(getActivity(), otpsetter.class);
            startActivity(intent);
        });
        return view;
    }

}