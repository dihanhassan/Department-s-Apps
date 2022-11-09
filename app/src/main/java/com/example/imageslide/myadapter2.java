package com.example.imageslide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter2 extends FirebaseRecyclerAdapter<model2,myadapter2.myviewholder> {


    public myadapter2(@NonNull FirebaseRecyclerOptions<model2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myadapter2.myviewholder holder, int position, @NonNull model2 model) {
        holder.name.setText(model.getName());
        holder.id.setText("Id : IT-"+model.getId());
        holder.season.setText("SEASON : "+model.getSeason());
        holder.mobile.setText("MOBILE : "+model.getMobile());
        holder.bloodGroup.setText("Group : "+model.getBloodGroup());

    }

    @NonNull
    @Override
    public myadapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        return new myadapter2.myviewholder(view);
    }

    static class myviewholder extends RecyclerView.ViewHolder{

        TextView name,id,season,mobile,bloodGroup;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nametext2);
            id = (TextView) itemView.findViewById(R.id.idtext2);
            season = (TextView) itemView.findViewById(R.id.seasontext2);
            mobile = (TextView) itemView.findViewById(R.id.mobiletext2);
            bloodGroup = (TextView) itemView.findViewById(R.id.bloodtext);
        }
    }

}
