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

public class TeacherInfo extends AppCompatActivity {
    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutTeacherInfoID);
        navigationView = (NavigationView) findViewById(R.id.navigatioTeacherInfoID);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarTeacherInfoID);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // WebView

        webView = (WebView) findViewById(R.id.webViewTeacherID);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/teachers_info.html");

    }
    public void TeacherInfoActivity(View view){
        Intent intent;
        if (view.getId()==R.id.teacherInfo_back_btnID){
            intent = new Intent(TeacherInfo.this,MainActivity.class);
            startActivity(intent);
        }

    }
}