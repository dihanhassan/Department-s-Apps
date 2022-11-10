package com.example.imageslide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.onesignal.OneSignal;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    ImageSlider imageSlider;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    CardView Bus,Teacher;

    private static final String ONESIGNAL_APP_ID = "0dc45e20-8423-40e8-8a7f-9e0c54770757";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Notification for my Apps

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        OneSignal.promptForPushNotifications();
        //---------------------------------------------------------------------------

        // One time otp
        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();


        // Image slider
        imageSlider = (ImageSlider) findViewById(R.id.imgSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.img_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        // Slide Menu

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutID);
        navigationView = (NavigationView) findViewById(R.id.MainnavigationID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();










        // card View optiosn
        Bus = (CardView) findViewById(R.id.cardViewBussID);
        Teacher = (CardView) findViewById(R.id.cardViewTeacherId);


    }

    @Override
    public void onBackPressed() {

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
        if (view.getId()==R.id.cardViewTeacherId){
            intent = new Intent(MainActivity.this,TeacherInfo.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewAppUpdateID){
            intent = new Intent(MainActivity.this,Apps_Update.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.cardViewBloodBankID){
            intent = new Intent(MainActivity.this,Blood_Bank.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.cardViewNoticeID){
            intent = new Intent(MainActivity.this,Notice.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.cardViewStaffID){
            intent = new Intent(MainActivity.this,StaffInfo.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.cardViewStudentID){
            intent = new Intent(MainActivity.this,afterStudent.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.cardViewMoreID){
            intent = new Intent(MainActivity.this,More.class);
            startActivity(intent);
        }

    }


}