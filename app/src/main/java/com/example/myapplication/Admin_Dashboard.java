package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Fregments.Attendance;
import com.example.myapplication.Fregments.Fee;
import com.example.myapplication.Fregments.Home;
import com.example.myapplication.Fregments.Library;
import com.example.myapplication.Fregments.Performance;
import com.example.myapplication.Fregments.notification;
import com.example.myapplication.Fregments.timetable;

public class Admin_Dashboard extends AppCompatActivity {
    ConstraintLayout Photo;
    TextView username,email_Address;
    CardView home_fragment ,Attendance_fragment,Performance_fragment,notification_fragment,Account_fragment,library_fragment,Settings_fragment,Time_table_fragment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Photo=findViewById(R.id.picture);
        username=findViewById(R.id.Profile_name);
        email_Address=findViewById(R.id.Profile_email);


        home_fragment=findViewById(R.id.home);
        Attendance_fragment=findViewById(R.id.Attendance);
        Performance_fragment=findViewById(R.id.Performance);
        notification_fragment=findViewById(R.id.notification);
        Account_fragment=findViewById(R.id.Fee);
        library_fragment=findViewById(R.id.library_books);
        Settings_fragment=findViewById(R.id.Setting);
        Time_table_fragment=findViewById(R.id.Time_table);

        home_fragment.setOnClickListener(view -> loadfragment(new Home()));
        Attendance_fragment.setOnClickListener(view -> loadfragment(new Attendance()));
        Performance_fragment.setOnClickListener(view -> loadfragment(new Performance()));
        notification_fragment.setOnClickListener(view -> loadfragment(new notification()));
        Account_fragment.setOnClickListener(view -> loadfragment(new Fee()));
        library_fragment.setOnClickListener(view -> loadfragment(new Library()));
        Settings_fragment.setOnClickListener(view -> loadfragment(new Settings()));
        Time_table_fragment.setOnClickListener(view -> loadfragment(new timetable()));


    }

    private void loadfragment  (Fragment frament){

        FragmentManager fm =getFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.professor_dashboard, frament);
        fragmentTransaction.commit();

    }

}