package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {


    Button Signup, login,fpass;
    TextView welcome, text_sign;
    TextInputLayout username, password;
    ImageView logo_image;
    String password_check;
    FirebaseAuth MAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Signup = findViewById(R.id.Sign_up);
        login = findViewById(R.id.login);
        fpass = findViewById(R.id.Forget_pass);
        MAuth = FirebaseAuth.getInstance();
        welcome = findViewById(R.id.text_wlcm);
        text_sign = findViewById(R.id.text_view);
        username = findViewById(R.id.User_name);
        password = findViewById(R.id.Password);
        logo_image = findViewById(R.id.logo_fg);


        login.setOnClickListener(view -> {

                    Toast.makeText(login.this,"Login Successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(login.this,Dashboard.class));
                    finish();
                });


        Signup.setOnClickListener(view -> {

            Intent i = new Intent(com.example.myapplication.login.this, SignUp.class);


            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View, String>(logo_image, "image_logo");
            pairs[1] = new Pair<View, String>(welcome, "text_logo");
            pairs[2] = new Pair<View, String>(text_sign, "tv");
            pairs[3] = new Pair<View, String>(username, "user");
            pairs[4] = new Pair<View, String>(password, "pass");
            pairs[5] = new Pair<View, String>(login, "log");
            pairs[6] = new Pair<View, String>(Signup, "sign");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(com.example.myapplication.login.this, pairs);
            startActivity(i, options.toBundle());
        });


        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetmail= new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your Email To Received Reset Link");
                passwordResetDialog.setView(resetmail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract email and send the reset link

                        String mail = resetmail.getText().toString();
                        MAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(com.example.myapplication.login.this, "Reset Password Link send on your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {

                                Toast.makeText(login.this, "Error ! Reset Link is Failed " , Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });

                passwordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog box
                    }
                });

                passwordResetDialog.create().show();


            }

        });



    }
}