package com.example.imageslide;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getName());
        holder.id.setText("Id : IT-"+model.getId());
        holder.season.setText("SEASON : "+model.getSeason());
        holder.mobile.setText("MOBILE : "+model.getMobile());
        holder.email.setText("EMAIL : "+model.getEmail());
        holder.home.setText("HOME : "+ model.getHomeTown());
        holder.service.setText("Service : "+model.getService());



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    static class myviewholder extends RecyclerView.ViewHolder{

        TextView name,id,season,mobile,email,home,service;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nametext);
            id = (TextView) itemView.findViewById(R.id.idtext);
            season = (TextView) itemView.findViewById(R.id.seasontext);
            mobile = (TextView) itemView.findViewById(R.id.mobiletext);
            email = (TextView) itemView.findViewById(R.id.emailtext);
            home = (TextView) itemView.findViewById(R.id.hometext);
            service = (TextView) itemView.findViewById(R.id.servicetext);


        }
    }
}
