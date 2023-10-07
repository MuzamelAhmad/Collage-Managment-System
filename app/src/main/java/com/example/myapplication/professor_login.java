package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class professor_login extends AppCompatActivity {


    Button Signup, login,fpass;
    TextView welcome, text_sign;
    TextInputLayout username, password;
    ImageView logo_image;
    String password_check;
    FirebaseAuth MAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_professor_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


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

          /*  String username_ = username.getEditText().getText().toString();
            String pass = password.getEditText().getText().toString();

            if (!username_.isEmpty()) {
                username.setError(null);
                username.setErrorEnabled(false);

                if (!pass.isEmpty()) {
                    password.setError(null);
                    password.setErrorEnabled(false);

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference parent_databaseReference = firebaseDatabase.getReference("User");

                    Query username_checker = parent_databaseReference.orderByChild("username").equalTo(username_);

                    username_checker.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot)
                        {
                            if (snapshot.exists())
                            {
                                username.setError(null);
                                username.setErrorEnabled(false);

                                password_check = snapshot.child(username_).child("password").getValue(String.class);

                                if (password_check.equals(pass)) {  */

                                    Toast.makeText(professor_login.this,"Login Successfully",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(professor_login.this,Admin_Dashboard.class));
                                    finish();
                               /* }
                                else
                                {
                                    password.setError("wrong Password");
                                }

                            }
                            else
                            {
                                username.setError("invalid Username");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                } else {
                    password.setError("Please Enter the Password ");
                }
            } else {
                username.setError("Please Enter the username ");
            }*/
        });




        Signup.setOnClickListener(view -> {

            Intent i = new Intent(professor_login.this, Professor_Registration.class);


            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View, String>(logo_image, "image_logo");
            pairs[1] = new Pair<View, String>(welcome, "text_logo");
            pairs[2] = new Pair<View, String>(text_sign, "tv");
            pairs[3] = new Pair<View, String>(username, "user");
            pairs[4] = new Pair<View, String>(password, "pass");
            pairs[5] = new Pair<View, String>(login, "log");
            pairs[6] = new Pair<View, String>(Signup, "sign");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(professor_login.this, pairs);
            startActivity(i, options.toBundle());

            Toast.makeText(professor_login.this, "Login Successfully", Toast.LENGTH_LONG).show();
            startActivity(new Intent(professor_login.this,Professor_Registration.class));
            finish();
        });


        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetmail = new EditText(v.getContext());
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
                                Toast.makeText(professor_login.this, "Reset Password Link send on your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {

                                Toast.makeText(professor_login.this, "Error ! Reset Link is Failed ", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });
                passwordResetDialog.create().show();


                passwordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog box
                    }
                });
            }
        });

    }
}