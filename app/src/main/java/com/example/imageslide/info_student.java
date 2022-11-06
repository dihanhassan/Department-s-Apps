package com.example.imageslide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

public class info_student extends AppCompatActivity {
    EditText name,id,season,mobile,email,homeTown,service;

    Button submit;

    DatabaseReference databaseReference ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);


        name = (EditText) findViewById(R.id.fullName_info);
        id = (EditText) findViewById(R.id.id_info);
        season = (EditText) findViewById(R.id.season_info);
        mobile = (EditText) findViewById(R.id.mobile_info);
        email = (EditText) findViewById(R.id.email_info);
        homeTown = (EditText) findViewById(R.id.homeTown_info);
        service = (EditText) findViewById(R.id.service_info);
        submit = (Button) findViewById(R.id.submitID_info);







        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadToFirebase();
            }
        });

    }

    public void infoCollectionBack (View view){
        Intent intent = new Intent(info_student.this,afterStudent.class);
        startActivity(intent);
    }


    private void uploadToFirebase() {
        String SEASON = season.getText().toString().trim();

        switch (SEASON){
            case "2020-21":
                databaseReference = FirebaseDatabase.getInstance().getReference("2020-21");
                break;

            case "2019-20":
                databaseReference = FirebaseDatabase.getInstance().getReference("2019-20");
                break;
            case "2018-19":
                databaseReference = FirebaseDatabase.getInstance().getReference("2018-19");
                break;
            case "2017-18":
                databaseReference = FirebaseDatabase.getInstance().getReference("2017-18");
                break;
            case "2016-17":
                databaseReference = FirebaseDatabase.getInstance().getReference("2016-17");
                break;

            case "2015-16":
                databaseReference = FirebaseDatabase.getInstance().getReference("2015-16");
                break;

            case "2014-15":
                databaseReference = FirebaseDatabase.getInstance().getReference("2014-15");
                break;
            case "2013-14":
                databaseReference = FirebaseDatabase.getInstance().getReference("2013-14");
                break;
            case "2012-13":
                databaseReference = FirebaseDatabase.getInstance().getReference("2012-13");
                break;
            case "2011-12":
                databaseReference = FirebaseDatabase.getInstance().getReference("2011-12");
                break;
            case "2010-11":
                databaseReference = FirebaseDatabase.getInstance().getReference("2010-11");
                break;

            case "2009-10":
                databaseReference = FirebaseDatabase.getInstance().getReference("2009-10");
                break;

            case "2008-9":
                databaseReference = FirebaseDatabase.getInstance().getReference("2008-9");
                break;

            case "2007-8":
                databaseReference = FirebaseDatabase.getInstance().getReference("2007-8");
                break;
            case "2006-7":
                databaseReference = FirebaseDatabase.getInstance().getReference("2006-7");
                break;

            case "2005-6":
                databaseReference = FirebaseDatabase.getInstance().getReference("2005-6");
                break;

            case "2004-5":
                databaseReference = FirebaseDatabase.getInstance().getReference("2004-5");
                break;

            case "2003-4":
                databaseReference = FirebaseDatabase.getInstance().getReference("2003-4");
                break;
            default:
                databaseReference = FirebaseDatabase.getInstance().getReference("MissSeason");


        }

            String Name = name.getText().toString().trim();
            String Id = id.getText().toString().trim();
            String Season = season.getText().toString().trim();
            String Mobile = mobile.getText().toString().trim();
            String Email = email.getText().toString().trim();
            String HomeTown = homeTown.getText().toString().trim();
            String Service = service.getText().toString().trim();

            dataholder info = new dataholder(Name,Id,Season,Mobile,Email,HomeTown,Service);

            databaseReference.child(Id).setValue(info);
            Toast.makeText(info_student.this, "Submited Successfully.", Toast.LENGTH_SHORT).show();

            name.setText("");
            id.setText("");
            season.setText("");
            mobile.setText("");
            email.setText("");
            homeTown.setText("");
            service.setText("");

    }

}