package com.example.imageslide;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class BloodGroup_AB_neg extends AppCompatActivity {

    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group_ab_neg);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutBloodGroup_AB_negID);
        navigationView = (NavigationView) findViewById(R.id.navigatioBloodGroup_AB_negID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarBloodGroup_AB_negID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // WebView

        webView = (WebView) findViewById(R.id.webViewBloodGroup_AB_negID);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/blood_ABneg.html");
    }

    public void ABnegActivity(View view){
        Intent intent;
        if (view.getId()==R.id.BloodGroup_AB_neg_btnID){
            intent = new Intent(BloodGroup_AB_neg.this,Blood_Bank.class);
            startActivity(intent);
        }
    }
}