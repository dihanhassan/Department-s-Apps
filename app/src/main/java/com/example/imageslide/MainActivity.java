package com.example.imageslide;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    CardView Bus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageSlider = (ImageSlider) findViewById(R.id.imgSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.img_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        // Slide Menu

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutID);
        navigationView = (NavigationView) findViewById(R.id.navigatioID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // card View optiosn
        Bus = (CardView) findViewById(R.id.cardViewBussID);


    }
    public  void optinons_menu(View view){
        Intent intent;
        if (view.getId()==R.id.cardViewBussID){
            intent = new Intent(MainActivity.this,BussSchedule.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.cardViewClassID){
            intent = new Intent(MainActivity.this,classRoutine.class);
            startActivity(intent);
        }
    }
}