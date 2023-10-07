package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.Calendar;

public class Professor_Registration extends AppCompatActivity {

    String[] Position_item = {"Assistant Professor ", "Professor", "Vice Principal", "Principal", "Visitor Professor", "Administrator","Librarian"};
    String[] Grade = {"null", "11G", "12G", "13G", "14G", "15G", "16G", "17G", "18G", "19G", "20G", "21G", "22G"};
    String[] listitem = {"Yes", "NO"};
    Button next;
    TextInputLayout _name, fname, _Cnic,salary_, posi, rank, regnumber, _military, _Phone, email, username, passwords;
    TextInputEditText set_name, set_Phone, set_passwords, set_username, set_email;
    MaterialTextView set_Date,join;
    CountryCodePicker ccp;
    ImageView imageView;
    TextView tv1, tv2;
    FirebaseDatabase root_node;
    DatabaseReference reference;
    AutoCompleteTextView position_auto, Military_auto, rank_items;
    ArrayAdapter<String> position_items;
    ArrayAdapter<String> list_items;
    ArrayAdapter<String>  rank_items_;
    int y;
    int m;
    int d;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_registration);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //          Button
        next = findViewById(R.id.rgnext);

        //     AutoCompleteTextView
        position_auto = findViewById(R.id.autoComplete_position);
        rank_items = findViewById(R.id.autoComplete_Rank);
        Military_auto = findViewById(R.id.autoCompletetext);

        //        ArrayAdapter<String>
        position_items = new ArrayAdapter<String>(this, R.layout.items_position, Position_item);
        rank_items_ = new ArrayAdapter<String>(this, R.layout.items_grade, Grade);
        list_items = new ArrayAdapter<String>(this, R.layout.items_military, listitem);


        //        ImageView
        imageView = findViewById(R.id.logo_fg);

        //           TextView
        tv1 = findViewById(R.id.text_see);
        tv2 = findViewById(R.id.sign_text);

        //       TextInputLayout
        _name = findViewById(R.id.name);
        fname = findViewById(R.id.fa_name);
        _Cnic = findViewById(R.id.Cnic);
        salary_ = findViewById(R.id.professor_salary);
        posi= findViewById(R.id.position);
        rank = findViewById(R.id.professor_grade);
        regnumber = findViewById(R.id.id_number);
        _military = findViewById(R.id.military);
        _Phone = findViewById(R.id.Phone);
        passwords = findViewById(R.id.Password);
        username = findViewById(R.id.User_name);
        email = findViewById(R.id.Email);

        //     TextInputEditText
        set_name = findViewById(R.id.ed_name);
        set_Phone = findViewById(R.id.ed_phone);
        set_passwords = findViewById(R.id.ed_password);
        set_username = findViewById(R.id.ed_username);
        set_email = findViewById(R.id.ed_email);
        set_Date = findViewById(R.id.ed_date);
        join = findViewById(R.id.date_joining);

        ccp = findViewById(R.id.countyCodePicker);

        ccp.registerCarrierNumberEditText(set_Phone);

        position_auto.setAdapter(position_items);

        position_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Professor_Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();

            }
        });

        rank_items.setAdapter(rank_items_);

        rank_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int s, long id) {

                String item = adapterView.getItemAtPosition(s).toString();
                Toast.makeText(Professor_Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();

            }
        });

        Military_auto.setAdapter(list_items);

        Military_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(Professor_Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();

            }
        });



        final Calendar c = Calendar.getInstance();

        set_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g = new DatePickerDialog(Professor_Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        set_Date.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, y, m, d);
                g.show();
            }
        });

        final Calendar J = Calendar.getInstance();

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = J.get(Calendar.YEAR);
                m = J.get(Calendar.MONTH);
                d = J.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g = new DatePickerDialog(Professor_Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        join.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, y, m, d);
                g.show();
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Professor_Registration.this, "Please Fill The Form", Toast.LENGTH_SHORT).show();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Professor_Registration.this,Administration.class);
                startActivity(intent);
                            }

        });


    }
    private void loadfragment  (Fragment frament)
    {

        FragmentManager fm =getFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Professor_container, frament);
        fragmentTransaction.commit();
    }
}