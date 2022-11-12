package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class afterStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_student);
    }

    public void toolbarBack (View view){
        Intent intent = new Intent(afterStudent.this,MainActivity.class);
        startActivity(intent);
    }

    public void afterStudentActivity(View view){
        Intent intent ;
        if (view.getId()==R.id.cardViewInformationID){
            intent = new Intent(afterStudent.this,StudentInfo.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewRegistrationID){
            intent = new Intent(afterStudent.this,Modify_info.class);
            startActivity(intent);
        }
    }
}