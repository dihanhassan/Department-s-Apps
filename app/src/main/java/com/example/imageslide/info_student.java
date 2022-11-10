package com.example.imageslide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
    EditText name,id,mobile,email,homeTown,service;
    //EditText BloodGroup;
    Button submit;
    Button skip;


    DatabaseReference databaseReference ;
    DatabaseReference databaseReference2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);



        String[] allSession = new String[] {
                "2003-4",
                "2004-5",
                "2005-6",
                "2006-7",
                "2007-8",
                "2008-9",
                "2009-10",
                "2010-11",
                "2011-12",
                "2012-13",
                "2013-14",
                "2014-15",
                "2015-16",
                "2016-17", "2017-18", "2018-19", "2019-20", "2020-21"
        };

        String[] allBlood = new String[] {
                "A+",
                "A-",
                "B+",
                "B-",
                "AB+",
                "AB-",
                "O+",
                "O-"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drpodownlayout,
                allSession
        );

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this,
                R.layout.drpodownlayout,
                allBlood
        );

        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.filled_exposed2);
        autoCompleteTextView2.setAdapter(adapter2);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)  findViewById(R.id.filled_exposed);
        autoCompleteTextView.setAdapter(adapter);







        name = (EditText) findViewById(R.id.fullName_info);
        id = (EditText) findViewById(R.id.id_info);
//        season = (EditText) findViewById(R.id.season_info);
        mobile = (EditText) findViewById(R.id.mobile_info);
        email = (EditText) findViewById(R.id.email_info);
        homeTown = (EditText) findViewById(R.id.homeTown_info);
        service = (EditText) findViewById(R.id.service_info);
        submit = (Button) findViewById(R.id.submitID_info);
        skip = (Button) findViewById(R.id.SkipID_info);
    //    BloodGroup = (EditText) findViewById(R.id.BloodGroupId);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(info_student.this, "Skiped.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(info_student.this,MainActivity.class);
                startActivity(intent);
            }
        });


        final String[] selected = new String[2];

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Item =(String) autoCompleteTextView.getText().toString().trim();

                selected[0] = Item;
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Item =(String) autoCompleteTextView2.getText().toString().trim();

                selected[1] = Item;
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // uploadToFirebase();

                String Name = name.getText().toString().trim();
                String Id = id.getText().toString().trim();
                String Season = selected[0].trim();
                String Mobile = mobile.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String HomeTown = homeTown.getText().toString().trim();
                String Service = service.getText().toString().trim();
                String Blood = selected[1].trim();



                if (    Name.isEmpty() ||
                        Id.isEmpty()   ||
                        Season.isEmpty() ||
                        Mobile.isEmpty() ||
                        Email.isEmpty()  ||
                        HomeTown.isEmpty() ||
                        Service.isEmpty() ||
                        Blood.isEmpty()
                )   {
                    Toast.makeText(info_student.this, "Incorrect Information . Try Again", Toast.LENGTH_SHORT).show();


                }else {

                    switch (Season) {
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

                    databaseReference.keepSynced(true);

                    dataholder info = new dataholder(Name, Id, Season, Mobile, Email, HomeTown, Service);

                    databaseReference.child(Id).setValue(info);


                    switch (Blood) {
                        case "A+":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("A+");
                            break;

                        case "A-":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("A-");
                            break;
                        case "B+":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("B+");
                            break;
                        case "B-":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("B-");
                            break;
                        case "AB+":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("AB+");
                            break;

                        case "AB-":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("AB-");
                            break;

                        case "O+":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("O+");
                            break;
                        case "O-":
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("O-");
                            break;

                        default:
                            databaseReference2 = FirebaseDatabase.getInstance().getReference("MissBlood");

                    }

                    databaseReference2.keepSynced(true);
                    dataHolderForBlood info2 = new dataHolderForBlood(Name, Id, Season, Mobile, Blood);

                    databaseReference2.child(Id).setValue(info2);

                    Toast.makeText(info_student.this, "Submited Successfully.", Toast.LENGTH_SHORT).show();

                    name.setText("");
                    id.setText("");
                    mobile.setText("");
                    email.setText("");
                    homeTown.setText("");
                    service.setText("");



                    Intent intent = new Intent(info_student.this,MainActivity.class);
                    startActivity(intent);


                }






            }


        });

    }

    @Override
    public void onBackPressed() {

    }

    //    public void infoCollectionBack (View view){
//
//        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);
//
//        String FristTime = preferences.getString("FirstTimeInstall","");
//
//        if (FristTime.equals("Yes")){
//            Toast.makeText(this, "Submit you info.", Toast.LENGTH_SHORT).show();
//        }else{
//            Intent intent = new Intent(info_student.this,afterStudent.class);
//            startActivity(intent);
//        }
//
//
//    }




}