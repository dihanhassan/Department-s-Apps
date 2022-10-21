package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class classRoutine extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    ImageButton imageButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_routine);
        // Toll bar back Button
        imageButton = (ImageButton) findViewById(R.id.routineBackID);

    }

    // routine back Button

    public void toolbarBack (View view){
        Intent intent = new Intent(classRoutine.this,MainActivity.class);
        startActivity(intent);
    }


    // Routine Click action
    public void showRoutine(View view){
        Intent intent;
        if (view.getId()==R.id.cardViewFirstID){
            intent = new Intent(classRoutine.this,routine_1y1s.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewSecondID){
            intent = new Intent(classRoutine.this,routine_2y2s.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewThirdID){
            intent = new Intent(classRoutine.this,routine_3y2s.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewFourthID){
            intent = new Intent(classRoutine.this,routine_4y2s.class);
            startActivity(intent);
        }
    }
}