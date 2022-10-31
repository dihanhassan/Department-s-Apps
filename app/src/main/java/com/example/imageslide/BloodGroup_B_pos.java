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

public class BloodGroup_B_pos extends AppCompatActivity {

    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group_bpos);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutBloodGroup_B_posID);
        navigationView = (NavigationView) findViewById(R.id.navigatioBloodGroup_B_posID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarBloodGroup_B_posID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // WebView

        webView = (WebView) findViewById(R.id.webViewBloodGroup_B_posID);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/blood_Bpos.html");

    }

    public void BposActivity(View view){
        Intent intent;
        if (view.getId()==R.id.BloodGroup_B_pos_btnID){
            intent = new Intent(BloodGroup_B_pos.this,Blood_Bank.class);
            startActivity(intent);
        }
    }
}