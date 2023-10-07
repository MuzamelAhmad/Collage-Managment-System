package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Fregments.otpsetter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class Parents_Registration extends AppCompatActivity {

    String[] Subitem = {"First year","Second year","BS Computer Science","BS Political Science","BS English","BBA"} ;
    String[] Semester = {"null","1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"} ;

    TextInputLayout rgname,rgroll_no,Sub,sem, rgemail, rgusername, rgphone, rgpassword;
    TextInputEditText set_name,set_Phone,set_passwords,set_username,set_email;
    ImageView imageView ;
    TextView tv1,tv2;
    CountryCodePicker ccp;
    Button p_next;
    FirebaseDatabase root_node;
    DatabaseReference reference;
    AutoCompleteTextView Subject_auto,Semester_items;
    ArrayAdapter<String> adopter_items;
    ArrayAdapter<String> Semester_items_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_registration);

        //          Button
        p_next = findViewById(R.id.parent_next);

        //     AutoCompleteTextView
        Subject_auto=findViewById(R.id.autoComplete);
        Semester_items=findViewById(R.id.autoComplete_semester);

        //        ArrayAdapter<String>
        adopter_items=new ArrayAdapter<String>(this , R.layout.items,Subitem);
        Semester_items_=new ArrayAdapter<String>(this , R.layout.items,Semester);

        //        ImageView
        imageView = findViewById(R.id.logo_fg);

        //           TextView
        tv1 = findViewById(R.id.text_see);
        tv2 = findViewById(R.id.sign_text);

        //     TextInputLayout
        rgusername = findViewById(R.id.User_name);
        rgpassword = findViewById(R.id.Password);
        rgname = findViewById(R.id.name);
        Sub=findViewById(R.id.Subject);
        sem=findViewById(R.id.semester);
        rgroll_no = findViewById(R.id.student_rollno);
        rgemail = findViewById(R.id.Email);
        rgphone = findViewById(R.id.Phone);

        //     TextInputEditText
        set_name = findViewById(R.id.parent_name);
        set_Phone = findViewById(R.id.parent_phone);
        set_passwords = findViewById(R.id.parent_password);
        set_username = findViewById(R.id.parent_username);
        set_email = findViewById(R.id.parent_email);

        ccp = findViewById(R.id.countyCodePicker);

        ccp.registerCarrierNumberEditText(set_Phone);





        Subject_auto.setAdapter(adopter_items);

        Subject_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Parents_Registration.this , "item: "+ item , Toast.LENGTH_SHORT).show();

            }
        });

        Semester_items.setAdapter(Semester_items_);

        Semester_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int s, long id) {

                String item = adapterView.getItemAtPosition(s).toString();
                Toast.makeText(Parents_Registration.this , "item: "+ item , Toast.LENGTH_SHORT).show();

            }
        });


        String v1 = getIntent().getStringExtra("value1");
        String v2 = getIntent().getStringExtra("value2");
        String v3 = getIntent().getStringExtra("value3");
        String v4 = getIntent().getStringExtra("value4");
        String v5 = getIntent().getStringExtra("value5");

        set_name.setText(v1);
        set_username.setText(v2);
        set_Phone.setText(v3);
        set_email.setText(v4);
        set_passwords.setText(v5);

        p_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   String usernam = rgusername.getEditText().getText().toString();
                String name = rgname.getEditText().getText().toString();
                String Roll_ = rgroll_no.getEditText().getText().toString();
                String Subj= Sub.getEditText().getText().toString();
                String semes = sem.getEditText().getText().toString();
                String email = rgemail.getEditText().getText().toString();
                String phone = rgphone.getEditText().getText().toString();
                String pass = rgpassword.getEditText().getText().toString();

                if (!name.isEmpty()) {
                    rgname.setError(null);
                    rgname.setErrorEnabled(false);

                    if (!Roll_.isEmpty()) {
                        rgroll_no.setError(null);
                        rgroll_no.setErrorEnabled(false);

                        if (!Subj.isEmpty()) {
                            Sub.setError(null);
                            Sub.setErrorEnabled(false);

                            if (!semes.isEmpty()) {
                                sem.setError(null);
                                sem.setErrorEnabled(false);

                                if (!usernam.isEmpty()) {
                                    rgusername.setError(null);
                                    rgusername.setErrorEnabled(false);

                                    if (!email.isEmpty()) {
                                        rgemail.setError(null);
                                        rgemail.setErrorEnabled(false);

                                        if (!phone.isEmpty() || phone.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
                                            rgphone.setError(null);
                                            rgphone.setErrorEnabled(false);

                                            if (!pass.isEmpty()) {
                                                rgpassword.setError(null);
                                                rgpassword.setErrorEnabled(false);


                                                if (email.matches("^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$")) {
                                                    rgemail.setError(null);
                                                    rgemail.setErrorEnabled(false);


                                                    if (pass.matches( "(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
                                                        rgpassword.setError(null);
                                                        rgpassword.setErrorEnabled(false);

                                                        root_node = FirebaseDatabase.getInstance();
                                                        reference = root_node.getReference("User/Parents");


                                                        String Name = rgname.getEditText().getText().toString();
                                                        String Roll_Number =  rgroll_no.getEditText().getText().toString();
                                                        String Subject =  Sub.getEditText().getText().toString();
                                                        String semester =  sem.getEditText().getText().toString();
                                                        String Username = rgusername.getEditText().getText().toString();
                                                        String Phone = rgphone.getEditText().getText().toString();
                                                        String Email = rgemail.getEditText().getText().toString();
                                                        String password = rgpassword.getEditText().getText().toString();

                                                        ParentsStorage helperclass = new ParentsStorage(Name ,Roll_Number,Subject,semester, Username, Phone , Email  , password);
                                                        reference.child(helperclass.Roll_Number).setValue(helperclass);*/

                                                        Intent intent= new Intent(Parents_Registration.this, otpsetter.class);
                                                      //  intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                        startActivity(intent);
                                                        finish();




                                                   /* }else {
                                                        rgpassword.setError("Please Enter the Strong Password ");
                                                    }

                                                } else {
                                                    rgemail.setError("Please Enter the valid email ");

                                                }
                                            } else {
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
                        } else {
                            rgname.setError("Please Enter the Name ");
                        }
                    } else {
                        rgname.setError("Please Enter the Name ");
                    }
                } else {
                    rgname.setError("Please Enter the Name ");
                }*/
            }
        });

        p_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Parents_Registration.this, "Please Fill the Form", Toast.LENGTH_SHORT).show();
            }
        });

    }


}