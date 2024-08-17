package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public final int SPLASH_SCREEN= 5000;
Animation top_anim,bottom_anim;
ImageView image;
TextView textView,textView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        image=findViewById(R.id.logo);
        textView=findViewById(R.id.tv);
        textView2=findViewById(R.id.tv2);

        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animtion);

        image.setAnimation(top_anim);
        textView.setAnimation(bottom_anim);
        textView2.setAnimation(bottom_anim);

        new Handler().postDelayed(() -> {
            Intent i= new Intent(MainActivity.this, roll_base.class);
            ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
           startActivity(i,options.toBundle());
           finish();

        },SPLASH_SCREEN);
    }
}