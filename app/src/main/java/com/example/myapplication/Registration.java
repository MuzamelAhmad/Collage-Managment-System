package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.myapplication.Fregments.otpsetter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.Calendar;


public class Registration extends AppCompatActivity {

    String[] Subitem = {"First year", "Second year", "BS Computer Science", "BS Political Science", "BS English", "BBA"};
    String[] Semester = {"fresh", "1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
    String[] listitem = {"Yes", "NO"};

    Button next;
    TextInputLayout _name, fname, _Cnic, roll_no, Sub, sem, mark, regnumber, _military, _Phone, email, username, passwords;
    TextInputEditText set_name, set_Phone, set_passwords, set_username, set_email;
    MaterialTextView set_Date;
    CountryCodePicker ccp;
    ImageView imageView;
    TextView tv1, tv2;
    FirebaseDatabase root_node;
    DatabaseReference reference;
    AutoCompleteTextView Subject_auto, Military_auto, Semester_items;
    ArrayAdapter<String> adopter_items;
    ArrayAdapter<String> list_items;
    ArrayAdapter<String> Semester_items_;
    int y;
    int m;
    int d;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //          Button
        next = findViewById(R.id.rgnext);

        //     AutoCompleteTextView
        Subject_auto = findViewById(R.id.autoComplete);
        Semester_items = findViewById(R.id.autoComplete_semester);
        Military_auto = findViewById(R.id.autoCompletetext);

        //        ArrayAdapter<String>
        adopter_items = new ArrayAdapter<String>(this, R.layout.items, Subitem);
        Semester_items_ = new ArrayAdapter<String>(this, R.layout.item_semester, Semester);
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
        roll_no = findViewById(R.id.student_rollno);
        Sub = findViewById(R.id.Subject);
        sem = findViewById(R.id.semester_);
        mark = findViewById(R.id.marks);
        regnumber = findViewById(R.id.rgnumber);
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

        ccp = findViewById(R.id.countyCodePicker);

        ccp.registerCarrierNumberEditText(set_Phone);

        Subject_auto.setAdapter(adopter_items);

        Subject_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int s, long id) {

                String item = adapterView.getItemAtPosition(s).toString();
                Toast.makeText(Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();
            }
            });

        Semester_items.setAdapter(Semester_items_);

        Semester_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int s, long id) {

                String item = adapterView.getItemAtPosition(s).toString();
                Toast.makeText(Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();

            }
        });

        Military_auto.setAdapter(list_items);

        Military_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(Registration.this, "item: " + item, Toast.LENGTH_SHORT).show();

            }
        });


        final Calendar c = Calendar.getInstance();

        set_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g = new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        set_Date.setText(i2 + "/" + (i1 + 1) + "/" + i);
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
                Toast.makeText(Registration.this, "Please Fill The Form", Toast.LENGTH_SHORT).show();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernam = username.getEditText().getText().toString();
                String Name_ = _name.getEditText().getText().toString();
                String father_ = fname.getEditText().getText().toString();
                String Cnic_ = _Cnic.getEditText().getText().toString();
                String roll_no_ = roll_no.getEditText().getText().toString();
                String subject_ = Sub.getEditText().getText().toString();
                String semes = sem.getEditText().getText().toString();
                String Date_O_B = set_Date.getText().toString();
                String marks_ = mark.getEditText().getText().toString();
                String rg_no_ = regnumber.getEditText().getText().toString();
                String military_ = _military.getEditText().getText().toString();
                String Email_ = email.getEditText().getText().toString();
                String phone_ = _Phone.getEditText().getText().toString();
                String pass = passwords.getEditText().getText().toString();

                if (!Name_.isEmpty()) {
                    _name.setError(null);
                    _name.setErrorEnabled(false);

                    if (!father_.isEmpty()) {
                        fname.setError(null);
                        fname.setErrorEnabled(false);

                        if (!Cnic_.isEmpty()) {
                            _Cnic.setError(null);
                            _Cnic.setErrorEnabled(false);

                            if (!roll_no_.isEmpty()) {
                                roll_no.setError(null);
                                roll_no.setErrorEnabled(false);

                                if (!subject_.isEmpty()) {
                                    Sub.setError(null);
                                    Sub.setErrorEnabled(false);

                                    if (!semes.isEmpty()) {
                                        sem.setError(null);
                                        sem.setErrorEnabled(false);

                                        if (!Date_O_B.isEmpty()) {
                                            set_Date.setError(null);


                                            if (!marks_.isEmpty()) {
                                                mark.setError(null);
                                                mark.setErrorEnabled(false);

                                                if (!rg_no_.isEmpty() ) {
                                                    regnumber.setError(null);
                                                    regnumber.setErrorEnabled(false);

                                                    if (!military_.isEmpty()) {
                                                        _military.setError(null);
                                                        _military.setErrorEnabled(false);

                                                        if (!usernam.isEmpty()) {
                                                            username.setError(null);
                                                            username.setErrorEnabled(false);

                                                            if (!Email_.isEmpty()) {
                                                                email.setError(null);
                                                                email.setErrorEnabled(false);

                                                                if (!phone_.isEmpty() && phone_.matches("^\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")){
                                                                    _Phone.setError(null);
                                                                    _Phone.setErrorEnabled(false);

                                                                    if (!pass.isEmpty()) {
                                                                        passwords.setError(null);
                                                                        passwords.setErrorEnabled(false);

                                                                        if (Email_.matches("^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$")) {
                                                                            email.setError(null);
                                                                            email.setErrorEnabled(false);

                                                                                if(subject_.matches("First year"))
                                                                                {
                                                                                    if (semes.matches("fresh"))
                                                                                    {
                                                                                    root_node = FirebaseDatabase.getInstance();
                                                                                    reference = root_node.getReference("/User/Student/first year");


                                                                                    String name = _name.getEditText().getText().toString();
                                                                                    String Father_name = fname.getEditText().getText().toString();
                                                                                    String CNIC = _Cnic.getEditText().getText().toString();
                                                                                    String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                    String Program = Sub.getEditText().getText().toString();
                                                                                    String Semester = sem.getEditText().getText().toString();
                                                                                    String Date_Of_barth = set_Date.getText().toString();
                                                                                    String Marks = mark.getEditText().getText().toString();
                                                                                    String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                    String Military_Member = _military.getEditText().getText().toString();
                                                                                    String Email = email.getEditText().getText().toString();
                                                                                    String phone = _Phone.getEditText().getText().toString();
                                                                                    String Username = username.getEditText().getText().toString();
                                                                                    String password = passwords.getEditText().getText().toString();


                                                                                    UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                    reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                    Intent intent= new Intent(Registration.this, Dashboard.class);
                                                                                    intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                    startActivity(intent);
                                                                                    finish();
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("Please Select the fresh");
                                                                                    }

                                                                                }
                                                                                else if (subject_.matches("Second year"))
                                                                                {
                                                                                    if (semes.matches("fresh"))
                                                                                    {
                                                                                    root_node = FirebaseDatabase.getInstance();
                                                                                    reference = root_node.getReference("User/Student/second year");


                                                                                    String name = _name.getEditText().getText().toString();
                                                                                    String Father_name = fname.getEditText().getText().toString();
                                                                                    String CNIC = _Cnic.getEditText().getText().toString();
                                                                                    String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                    String Program = Sub.getEditText().getText().toString();
                                                                                    String Semester = sem.getEditText().getText().toString();
                                                                                    String Date_Of_barth = set_Date.getText().toString();
                                                                                    String Marks = mark.getEditText().getText().toString();
                                                                                    String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                    String Military_Member = _military.getEditText().getText().toString();
                                                                                    String Email = email.getEditText().getText().toString();
                                                                                    String phone = _Phone.getEditText().getText().toString();
                                                                                    String Username = username.getEditText().getText().toString();
                                                                                    String password = passwords.getEditText().getText().toString();


                                                                                    UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                    reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                    Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                    intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                    startActivity(intent);
                                                                                    finish();
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("Please Select the Null");
                                                                                    }

                                                                                }
                                                                                else if (subject_.matches("BS Computer Science"))
                                                                                {
                                                                                    if (semes.matches("1st Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/1st Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("2nd Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/2nd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if (semes.matches("3rd Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/3rd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if(semes.matches("4th Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/4th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if (semes.matches("5th Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/5th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if (semes.matches("6th Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/6th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if (semes.matches("7th Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/7th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else if (semes.matches("8th Semester"))
                                                                                    { root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Computer Science/8th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        Log.d("REST", ccp.getFullNumberWithPlus().toString());
                                                                                        startActivity(intent);
                                                                                        finish();

                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("you can't Select Fresh");
                                                                                    }

                                                                                }
                                                                                else if (subject_.matches("BS Political Science"))
                                                                                {
                                                                                    if (semes.matches("1st Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/1st Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("2nd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/2nd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("3rd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/3rd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("4th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/4th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("5th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/5th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("6th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/6th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("7th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/7th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("8th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS Political Science/8th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("you can't Select null");
                                                                                    }
                                                                                }
                                                                                else if (subject_.matches("BS English"))
                                                                                {
                                                                                    if (semes.matches("1st Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/1st Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("2nd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/2nd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("3rd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/3rd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("4th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/4th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("5th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/5th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("6th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/6th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("7th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/7th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("8th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BS English/8th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("you can't Select null");
                                                                                    }
                                                                                }
                                                                                else if (subject_.matches("BBA"))
                                                                                {
                                                                                    if (semes.matches("1st Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/1st Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("2nd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/2nd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if(semes.matches("3rd Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/3rd Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("4th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/4th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("5th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/5th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("6th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/6th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if (semes.matches("7th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/7th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else if(semes.matches("8th Semester"))
                                                                                    {
                                                                                        root_node = FirebaseDatabase.getInstance();
                                                                                        reference = root_node.getReference("/User/Student/BBA/8th Semester");


                                                                                        String name = _name.getEditText().getText().toString();
                                                                                        String Father_name = fname.getEditText().getText().toString();
                                                                                        String CNIC = _Cnic.getEditText().getText().toString();
                                                                                        String Roll_Number = roll_no.getEditText().getText().toString();
                                                                                        String Program = Sub.getEditText().getText().toString();
                                                                                        String Semester = sem.getEditText().getText().toString();
                                                                                        String Date_Of_barth = set_Date.getText().toString();
                                                                                        String Marks = mark.getEditText().getText().toString();
                                                                                        String Registration_Number = regnumber.getEditText().getText().toString();
                                                                                        String Military_Member = _military.getEditText().getText().toString();
                                                                                        String Email = email.getEditText().getText().toString();
                                                                                        String phone = _Phone.getEditText().getText().toString();
                                                                                        String Username = username.getEditText().getText().toString();
                                                                                        String password = passwords.getEditText().getText().toString();


                                                                                        UserHelperClass helper_class = new UserHelperClass(name, Father_name, CNIC, Roll_Number, Program, Semester, Date_Of_barth, Marks, Registration_Number, Military_Member, Username, phone, Email, password);
                                                                                        reference.child(helper_class.Roll_Number).setValue(helper_class);

                                                                                        Intent intent= new Intent(Registration.this, otpsetter.class);
                                                                                        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        sem.setError("you can't Select null");
                                                                                    }
                                                                                }
                                                                        } else {
                                                                            email.setError("Please Enter the valid email ");
                                                                        }
                                                                    } else {
                                                                        passwords.setError("Please Enter the Password ");
                                                                    }
                                                                } else {
                                                                    _Phone.setError("Please Enter the Phone number ");
                                                                }
                                                            } else {
                                                                email.setError("Please Enter the Email ");
                                                            }
                                                        } else {
                                                            username.setError("Please Enter the username ");
                                                        }
                                                    } else {
                                                        _military.setError("Please Select the Options ");
                                                    }
                                                } else {
                                                    regnumber.setError("Please Enter the Registration Number ");
                                                }
                                            } else {
                                                mark.setError("Please Enter the Marks ");
                                            }
                                        } else {
                                            set_Date.setError("Please Select the Date of barth ");
                                        }
                                    } else {
                                        sem.setError("Please Select the Semester");
                                    }
                                } else {
                                    Sub.setError("Please Select the subject");
                                }
                            } else {
                                roll_no.setError("Please Enter your Roll Number ");
                            }
                        } else {
                            _Cnic.setError("Please Enter the CNIC ");
                        }
                    } else {
                        fname.setError("Please Enter the Father Name ");
                    }
                } else {
                    _name.setError("Please Enter the Name ");
                }

            }
        });


    }

}