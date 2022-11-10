package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class More extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


    }

    public void showMore (View view){


    }

    public void MoreActivity (View view){
        Intent intent;
        if (view.getId()==R.id.MoreBackID){
            intent = new Intent(More.this,MainActivity.class);
            startActivity(intent);
        }
    }
}