package com.example.imageslide;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class BussSchedule extends AppCompatActivity {
    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buss_schedule);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutBussID);
        navigationView = (NavigationView) findViewById(R.id.navigatioBusID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarBusID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();





        // web View
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/bus.html");
        imageButton = (ImageButton) findViewById(R.id.buss_back_btnID);
    }
    public void BussActivity(View view){
        Intent intent;
        if (view.getId()== R.id.buss_back_btnID){
            intent = new Intent(BussSchedule.this,MainActivity.class);
            startActivity(intent);
        }
    }
}