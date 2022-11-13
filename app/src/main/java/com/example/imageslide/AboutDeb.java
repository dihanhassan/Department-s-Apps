package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutDeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_deb);
    }
    public void AboutActivity (View view){
        if (view.getId()==R.id.AboutBackID){
            Intent intent= new Intent(AboutDeb.this,More.class);
            startActivity(intent);
        }
    }
}