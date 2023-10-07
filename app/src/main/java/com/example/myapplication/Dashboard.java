package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Fregments.Home;
import com.example.myapplication.Fregments.Library;
import com.example.myapplication.Fregments.notification;
import com.example.myapplication.Fregments.timetable;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

public class Dashboard extends AppCompatActivity {
   FloatingActionButton Photo;
   ShapeableImageView profile_pic;
   TextView username,email_Address;
   CardView home_fragment ,Attendance_fragment,Performance_fragment,notification_fragment,Account_fragment,library_fragment,Settings_fragment,Time_table_fragment;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        Photo=findViewById(R.id.floatingActionButton);
        profile_pic=findViewById(R.id.imageview);
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
        notification_fragment.setOnClickListener(view -> loadfragment(new notification()));
        library_fragment.setOnClickListener(view -> loadfragment(new Library()));

        Time_table_fragment.setOnClickListener(view -> loadfragment(new timetable()));



        Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.with(Dashboard.this)
                        .crop(180,180)	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
             Uri uri = data.getData();


                    // Use Uri object instead of File to avoid storage permissions
                    profile_pic.setImageURI(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadfragment  (Fragment frament){

        FragmentManager fm =getFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Student_dashboard, frament);
        fragmentTransaction.commit();


    }
}