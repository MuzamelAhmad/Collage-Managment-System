package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class roll_base extends AppCompatActivity {
    LinearLayout layout1,layout2,bg;
    Animation top_anim,bottom_anim;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_roll_base);
        layout1=findViewById(R.id.professor_);
        layout2=findViewById(R.id.student_);
        bg=findViewById(R.id.anim);

        // Animation
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animtion);

        bg.startAnimation(top_anim);
        layout1.startAnimation(bottom_anim);
        layout2.startAnimation(bottom_anim);


        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(roll_base.this, professor_login.class);
                startActivity(intent);

            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(roll_base.this, login.class);
                startActivity(intent);

            }
        });
    }
}