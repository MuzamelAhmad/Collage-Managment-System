package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class SignUp extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Button rglogin, rgnext;
    TextInputLayout rgname, rgemail, rgusername, rgphone, rgpassword;
    TextInputEditText ccpnumber;
    ImageView rglogo_image;
    TextView rgwelcome, rgtext_sign;
    CountryCodePicker ccp;
    RadioGroup radioGroup;
    AppCompatRadioButton stu, rgparent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Buttons
        rglogin = findViewById(R.id.login);
        rgnext = findViewById(R.id.next);
        //text input layout
        rgusername = findViewById(R.id.User_name);
        rgpassword = findViewById(R.id.Password);
        rgname = findViewById(R.id.name);
        rgemail = findViewById(R.id.Email);
        rgphone = findViewById(R.id.Phone);
        //imageview
        rglogo_image = findViewById(R.id.logo_fg);
        // text view
        rgwelcome = findViewById(R.id.text_see);
        rgtext_sign = findViewById(R.id.sign_text);
        // radioGroup
        radioGroup = findViewById(R.id.rggroup);
        // radioGroup button
        stu = findViewById(R.id.Student);
        rgparent = findViewById(R.id.parent);


        ccp = findViewById(R.id.countyCodePicker);
        ccpnumber=findViewById(R.id.ccpnum);


        radioGroup.setOnCheckedChangeListener(this);


        rglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this, login.class);

                Pair[] pairs = new Pair[10];

                pairs[0] = new Pair<View, String>(rglogo_image, "image_logo");
                pairs[1] = new Pair<View, String>(rgwelcome, "text_logo");
                pairs[2] = new Pair<View, String>(rgtext_sign, "tv");
                pairs[3] = new Pair<View, String>(rgusername, "user");
                pairs[4] = new Pair<View, String>(rgpassword, "pass");
                pairs[5] = new Pair<View, String>(rgemail, "Email");
                pairs[6] = new Pair<View, String>(rgphone, "phone");
                pairs[7] = new Pair<View, String>(rgname, "nam");
                pairs[8] = new Pair<View, String>(rgnext, "go");
                pairs[9] = new Pair<View, String>(rglogin, "log");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(i, options.toBundle());
            }
        });

        rgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp.this, "select the Id", Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {


        switch (i) {
            case R.id.Student:
                rgnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String usernam = rgusername.getEditText().getText().toString();
                        String name = rgname.getEditText().getText().toString();
                        String email = rgemail.getEditText().getText().toString();
                        String phone = rgphone.getEditText().getText().toString();
                        String pass = rgpassword.getEditText().getText().toString();

                        if (!name.isEmpty()) {
                            rgname.setError(null);
                            rgname.setErrorEnabled(false);

                            if (!usernam.isEmpty()) {
                                rgusername.setError(null);
                                rgusername.setErrorEnabled(false);

                                if (!email.isEmpty()) {
                                    rgemail.setError(null);
                                    rgemail.setErrorEnabled(false);

                                    if (!phone.isEmpty()) {
                                        rgphone.setError(null);
                                        rgphone.setErrorEnabled(false);

                                        if (!pass.isEmpty() || phone.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
                                            rgpassword.setError(null);
                                            rgpassword.setErrorEnabled(false);


                                            if (email.matches( "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$")) {
                                                rgemail.setError(null);
                                                rgemail.setErrorEnabled(false);

                                                if (pass.matches( "(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
                                                    rgpassword.setError(null);
                                                    rgpassword.setErrorEnabled(false);

                                                    Intent intent= new Intent(SignUp.this,Registration.class);
                                                    intent.putExtra("value1",name);
                                                    intent.putExtra("value2",usernam);
                                                    intent.putExtra("value3",phone);
                                                    intent.putExtra("value4",email);
                                                    intent.putExtra("value5",pass);
                                                    startActivity(intent);
                                                    finish();

                                                }else {
                                                    rgpassword.setError("Please Enter the Strong Password ");
                                                }
                                            }else {
                                                rgemail.setError("Please Enter the valid email ");

                                            }
                                        }else {
                                            rgpassword.setError("Please Enter the Password ");
                                        }
                                    } else {
                                        rgphone.setError("Please Enter the Phone number ");
                                    }
                                } else {
                                    rgemail.setError("Please Enter the Email ");
                                }
                            } else {
                                rgusername.setError("Please Enter the username ");
                            }
                        } else {
                            rgname.setError("Please Enter the Name ");
                        }


                    }

                });

                break;

            case R.id.parent:

                rgnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String usernam = rgusername.getEditText().getText().toString();
                        String name = rgname.getEditText().getText().toString();
                        String email = rgemail.getEditText().getText().toString();
                        String phone = rgphone.getEditText().getText().toString();
                        String pass = rgpassword.getEditText().getText().toString();

                        if (!name.isEmpty()) {
                            rgname.setError(null);
                            rgname.setErrorEnabled(false);

                            if (!usernam.isEmpty()) {
                                rgusername.setError(null);
                                rgusername.setErrorEnabled(false);

                                if (!email.isEmpty()) {
                                    rgemail.setError(null);
                                    rgemail.setErrorEnabled(false);

                                    if (!phone.isEmpty()) {
                                        rgphone.setError(null);
                                        rgphone.setErrorEnabled(false);

                                        if (!pass.isEmpty() || phone.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
                                            rgpassword.setError(null);
                                            rgpassword.setErrorEnabled(false);


                                            if (email.matches( "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$")) {
                                                rgemail.setError(null);
                                                rgemail.setErrorEnabled(false);

                                                if (pass.matches( "(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
                                                    rgpassword.setError(null);
                                                    rgpassword.setErrorEnabled(false);

                                                Intent intent= new Intent(SignUp.this,Parents_Registration.class);
                                                intent.putExtra("value1",name);
                                                intent.putExtra("value2",usernam);
                                                intent.putExtra("value3",phone);
                                                intent.putExtra("value4",email);
                                                intent.putExtra("value5",pass);
                                                startActivity(intent);
                                                finish();

                                                }else {
                                                    rgpassword.setError("Please Enter the Strong Password ");
                                                }
                                            }else {
                                                rgemail.setError("Please Enter the valid email ");

                                            }
                                        }else {
                                            rgpassword.setError("Please Enter the Password ");
                                        }
                                    } else {
                                        rgphone.setError("Please Enter the Phone number ");
                                    }
                                } else {
                                    rgemail.setError("Please Enter the Email ");
                                }
                            } else {
                                rgusername.setError("Please Enter the username ");
                            }
                        } else {
                            rgname.setError("Please Enter the Name ");
                        }


                    }

                });

                break;
        }

    }
}