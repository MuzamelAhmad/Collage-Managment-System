package com.example.myapplication.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.OurView_Model;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerOurViewViewHolder extends RecyclerView.Adapter<RecyclerOurViewViewHolder.View_Holder> {

    Context context ;
    ArrayList<OurView_Model> Rc_Our_view;
    private int lastposition = -1;

    public RecyclerOurViewViewHolder(FragmentActivity activity, ArrayList<OurView_Model> rcOurView) {
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.rc_container,parent,false);

        return new RecyclerOurViewViewHolder.View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        OurView_Model currentItem = Rc_Our_view.get(position);

        holder. Profile_img.setImageResource(Rc_Our_view.get(position).getProfileImg());
        holder. imageView.setImageResource(Rc_Our_view.get(position).getImgView());
        holder.P_name.setText(Rc_Our_view.get(position).getP_name());
        holder.P_email.setText(Rc_Our_view.get(position).getP_email());
        holder.Exp.setText(Rc_Our_view.get(position).getExp());
        holder.Educ.setText(Rc_Our_view.get(position).getEduc());
        holder.Org.setText(Rc_Our_view.get(position).getOrg());

        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return Rc_Our_view.size();
    }

    public static class View_Holder extends RecyclerView.ViewHolder{

        ImageView Profile_img,imageView;
        TextView P_name,P_email,Exp,Educ,Org;

        public View_Holder(@NonNull View itemView) {
            super(itemView);

           P_name=itemView.findViewById(R.id.Profile_name);
           P_email=itemView.findViewById(R.id.Profile_email);
           Exp=itemView.findViewById(R.id.education_Exprn);
           Educ=itemView.findViewById(R.id.education_name);
           Org=itemView.findViewById(R.id.Organization_name);

                    //ImageView
           Profile_img=itemView.findViewById(R.id.img);
           imageView=itemView.findViewById(R.id.background_view);



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
