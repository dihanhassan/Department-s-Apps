package com.example.imageslide;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class Notice extends AppCompatActivity {

    WebView webView;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        // Tool Bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutr_Notice);
        navigationView = (NavigationView) findViewById(R.id.navigatio_Notice);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBar_Notice);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigration_open, R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // web Site notice View

        webView = (WebView) findViewById(R.id.webViewNotice);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ict.mbstu.ac.bd/notices/all");
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}