package com.example.myapplication.Fregments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Attendance_Model;
import com.example.myapplication.R;
import com.example.myapplication.Adopter.RecyclerAttendanceViewholder;

import java.util.ArrayList;

public class Attendance extends Fragment{
    RecyclerView rc;
    Button Attend_go;
    RadioGroup Attendance_;
    RadioButton radioButton_A,radioButton_P,radioButton_l;
    ArrayList<Attendance_Model> Rc_Attendance = new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
       // View v = inflater.inflate(R.layout.rc_container, container, false);


        rc = view.findViewById(R.id.recycler_view_attendance);
        Attendance_ = view.findViewById(R.id.rg_Attendance);
        radioButton_A = view.findViewById(R.id.radioButton_A);
        radioButton_P = view.findViewById(R.id.radioButton_P);
        radioButton_l = view.findViewById(R.id.radioButton_l);
        Attend_go = view.findViewById(R.id.Attendance_checked);




       rc.setLayoutManager(new LinearLayoutManager(this.getContext()));




        Rc_Attendance.add(new Attendance_Model(R.drawable.a,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.b,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.c,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.d,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.e,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.f,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.g,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.h,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.i,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.j,"Aizaz","191296"));
        Rc_Attendance.add(new Attendance_Model(R.drawable.k,"Aizaz","191296"));



        RecyclerAttendanceViewholder viewholder = new RecyclerAttendanceViewholder((FragmentActivity) this.getActivity(),Rc_Attendance);
        rc.setAdapter(viewholder);

        return view;

       }

  /*  @Override
    public void RadioButton() {

        Attend_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Attendance_.setOnCheckedChangeListener((group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.radioButton_A:
                            Attendance_Model currentItem = null;
                            currentItem.setSelectedRadio("A");
                            break;
                        case R.id.radioButton_P:
                            currentItem.setSelectedRadio("P");
                            break;
                        case R.id.radioButton_l:
                            currentItem.setSelectedRadio("L");
                            break;

                }
            }
        }

        });

    }*/


}