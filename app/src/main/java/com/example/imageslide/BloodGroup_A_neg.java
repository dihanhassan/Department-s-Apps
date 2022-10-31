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

public class BloodGroup_A_neg extends AppCompatActivity {

    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group_aneg);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutBloodGroup_A_negID);
        navigationView = (NavigationView) findViewById(R.id.navigatioBloodGroup_A_negID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarBloodGroup_A_negID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // WebView

        webView = (WebView) findViewById(R.id.webViewBloodGroup_A_negID);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/blood_Aneg.html");
    }
    public void AnegActivity(View view){
        Intent intent;
        if (view.getId()==R.id.BloodGroup_A_neg_btnID){
            intent = new Intent(BloodGroup_A_neg.this,Blood_Bank.class);
            startActivity(intent);
        }
    }
}