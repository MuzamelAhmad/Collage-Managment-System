package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

public class Administration extends AppCompatActivity { FloatingActionButton Photo;
    ShapeableImageView profile_pic;
    TextView username,email_Address;
    CardView home_view ,Attendance_fragment,Performance_fragment,notification_fragment,Account_fragment,library_fragment,Settings_fragment,Time_table_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        Photo=findViewById(R.id.floatingActionButton);
        profile_pic=findViewById(R.id.imageview);
        username=findViewById(R.id.Profile_name);
        email_Address=findViewById(R.id.Profile_email);


        home_view=findViewById(R.id.home);
        Attendance_fragment=findViewById(R.id.Attendance);
        Performance_fragment=findViewById(R.id.Performance);
        notification_fragment=findViewById(R.id.notification);
        Account_fragment=findViewById(R.id.Fee);
        library_fragment=findViewById(R.id.library_books);
        Settings_fragment=findViewById(R.id.Setting);
        Time_table_fragment=findViewById(R.id.Time_table);


        home_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Administration.this, Admin_Our_view.class);
                startActivity(intent);
            }
        });

        Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.with(Administration.this)
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
}