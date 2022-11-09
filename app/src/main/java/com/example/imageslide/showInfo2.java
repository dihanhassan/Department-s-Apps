package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class showInfo2 extends AppCompatActivity {
    RecyclerView recview;
    myadapter2 adapter;
    String GROUP;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info2);

        recview = (RecyclerView) findViewById(R.id.recview2);
        recview.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            GROUP = bundle.getString("tag2");
        }

        FirebaseRecyclerOptions<model2> options =
                new FirebaseRecyclerOptions.Builder<model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(GROUP), model2.class)
                        .build();


        adapter = new myadapter2(options);
        recview.setAdapter(adapter);



    }

    public void bloodbankID(View view){
        if (view.getId()==R.id.BloodBackBackID){
            Intent intent = new Intent(showInfo2.this,Blood_Bank.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}