package com.example.myapplication.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Attendance_Model;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerAttendanceViewholder extends RecyclerView.Adapter<RecyclerAttendanceViewholder.ViewHolder> {
    Context  context ;
    ArrayList<Attendance_Model> Rc_Attendance;
   private int lastposition = -1;

    public RecyclerAttendanceViewholder(FragmentActivity context, ArrayList<Attendance_Model> Rc_Attendance){
        this.context = (Context) context;
        this.Rc_Attendance = Rc_Attendance;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(context).inflate(R.layout.rc_container,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Attendance_Model currentItem = Rc_Attendance.get(position);

        holder.Student_image.setImageResource(Rc_Attendance.get(position).img);
        holder.S_name.setText(Rc_Attendance.get(position).name);
        holder.S_rollnum.setText(Rc_Attendance.get(position).roll_number);

        setAnimation(holder.itemView,position);

        // Handle radio button clicks
      holder.Attendance_.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radioButton_A:

                    currentItem.setSelectedRadio("A");
                    break;
                case R.id.radioButton_P:
                    currentItem.setSelectedRadio("P");
                    break;
                case R.id.radioButton_l:
                    currentItem.setSelectedRadio("L");
                    break;
            }
        });

}

    @Override
    public int getItemCount() {
        return Rc_Attendance.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView S_name,S_rollnum;
        ImageView Student_image;
        RadioGroup Attendance_;
        Button Attend_go;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            S_name=itemView.findViewById(R.id.student_name);
            S_rollnum=itemView.findViewById(R.id.student_Roll_number);
            Student_image=itemView.findViewById(R.id.student_image);
            Attendance_=itemView.findViewById(R.id.rg_Attendance);
            Attend_go = itemView.findViewById(R.id.Attendance_checked);

        }
    }
    private void setAnimation(View viewToAnimte, int position){

        if(position>lastposition){
            Animation slidein = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimte.setAnimation(slidein);
            lastposition = position;
        }


    }
}
