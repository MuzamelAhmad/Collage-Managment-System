package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adopter.RecyclerOurViewViewHolder;
import com.example.myapplication.Models.OurView_Model;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Admin_Our_view extends AppCompatActivity {
    RecyclerView rc_Our_view;
    ShapeableImageView bg_img,pro_img;

    RecyclerOurViewViewHolder adopter ;
    FloatingActionButton floatingActionButton;
    ArrayList<OurView_Model> Rc_Our_view = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_our_view);

        floatingActionButton =findViewById(R.id.floatingActionButton);
        rc_Our_view =findViewById(R.id.recycler_view_Our_view);

       /* rc_Our_view.setLayoutManager(new LinearLayoutManager(getApplicationContext());*/

        RecyclerOurViewViewHolder View_Holder = new RecyclerOurViewViewHolder(this,Rc_Our_view);

        rc_Our_view.setAdapter(View_Holder);



        floatingActionButton.setOnClickListener(view1 -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_ouer_view_dailog);

            EditText p_name,p_email;
            FloatingActionButton bg_btn,Pro_btn;
            TextInputEditText Exp , Educ,Org;
            Button AddNewOne;

            AddNewOne = dialog.findViewById(R.id.btn_add);
            bg_btn = dialog.findViewById(R.id.floatingActionButton_bg);
            Pro_btn = dialog.findViewById(R.id.floatingActionButtonP);
            p_name = dialog.findViewById(R.id.Profile_name);
            bg_img = dialog.findViewById(R.id.background_view);
            pro_img = dialog.findViewById(R.id.imageview);
            p_email = dialog.findViewById(R.id.Profile_email);
            Exp = dialog.findViewById(R.id.education_Exprn);
            Educ = dialog.findViewById(R.id.education_name);
            Org = dialog.findViewById(R.id.Organization_name);

            bg_btn.setOnClickListener(view11 -> ImagePicker.with(Admin_Our_view.this)
                    .crop(180,180)	    			//Crop image(Optional), Check Customization for more option
                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start());
            Pro_btn.setOnClickListener(view113 -> ImagePicker.with(Admin_Our_view.this)
                    .crop(180,180)	    			//Crop image(Optional), Check Customization for more option
                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start());



            AddNewOne.setOnClickListener(view112 -> {

                String name = p_name.getText().toString();
                String Email_P = p_email.getText().toString();
                String Exp_ = Exp.getText().toString();
                String _Educ =Educ.getText().toString();
                String organize = Org.getText().toString();


                if (!name.isEmpty()) {
                    p_name.setError(null);
                    p_name.setEnabled(false);

                    if (!Email_P.isEmpty()) {
                        p_email.setError(null);
                        p_email.setEnabled(false);

                        if (!Exp_.isEmpty()) {
                            Exp.setError(null);
                            Exp.setEnabled(false);

                            if (!_Educ.isEmpty()) {
                                Educ.setError(null);
                                Educ.setEnabled(false);

                                if (!organize.isEmpty()) {
                                    Org.setError(null);
                                    Org.setEnabled(false);

                                    if (Email_P.matches("^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9. -]+$")) {
                                        p_email.setError(null);
                                        p_email.setEnabled(false);

                                        Rc_Our_view.add(new OurView_Model(name, Email_P, Exp_, _Educ, organize));

                                        adopter.notifyItemInserted(Rc_Our_view.size()-1);
                                        rc_Our_view.scrollToPosition(Rc_Our_view.size()-1);

                                        dialog.dismiss();

                                    } else {
                                        p_email.setError("Please Enter the valid email ");
                                    }

                                } else {
                                    Org.setError("Please Enter the Password ");
                                }
                            } else {
                                Educ.setError("Please Enter the Password ");
                            }
                        } else {
                            Exp.setError("Please Enter the Phone number ");
                        }
                    } else {
                        p_email.setError("Please Enter the Email ");
                    }
                } else {
                    p_name.setError("Please Enter the username ");
                }
            });

            dialog.show();
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            assert data != null;
            Uri uri = data.getData();
            // Use Uri object instead of File to avoid storage permissions
            bg_img.setImageURI(uri);
        }
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri uri = data.getData();
            // Use Uri object instead of File to avoid storage permissions
            pro_img.setImageURI(uri);
        }

        else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}