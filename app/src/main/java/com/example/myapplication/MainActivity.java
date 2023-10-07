package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int SPLASH_SCREEN= 5000;
Animation top_anim,bottom_anim;
ImageView image;
TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

            Pair[] pairs= new Pair[2];
            pairs[0] = new Pair<View,String>(image,"image_logo");
            pairs[1] = new Pair<View,String>(textView,"text_logo");
            ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
           startActivity(i,options.toBundle());
           finish();

        },SPLASH_SCREEN);
    }
}