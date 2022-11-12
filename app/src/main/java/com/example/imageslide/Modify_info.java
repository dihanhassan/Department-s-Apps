package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Modify_info extends AppCompatActivity {

    EditText name,id,mobile,email,homeTown,service;
    Button submit;
    Button skip;


    DatabaseReference databaseReference ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);

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

        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.filled_exposed22);
        autoCompleteTextView2.setAdapter(adapter2);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)  findViewById(R.id.filled_exposed2);
        autoCompleteTextView.setAdapter(adapter);







        name = (EditText) findViewById(R.id.fullName_info2);
        id = (EditText) findViewById(R.id.id_info2);
//        season = (EditText) findViewById(R.id.season_info);
        mobile = (EditText) findViewById(R.id.mobile_info2);
        email = (EditText) findViewById(R.id.email_info2);
        homeTown = (EditText) findViewById(R.id.homeTown_info2);
        service = (EditText) findViewById(R.id.service_info2);
        submit = (Button) findViewById(R.id.submitID_info2);

        //    BloodGroup = (EditText) findViewById(R.id.BloodGroupId);



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
                    Toast.makeText(Modify_info.this, "Incorrect Information . Try Again", Toast.LENGTH_SHORT).show();


                }else {

                    databaseReference = FirebaseDatabase.getInstance().getReference("Information Modify Request");

                    databaseReference.keepSynced(true);

                    dataHolderForModify info = new dataHolderForModify(Name, Id, Season, Mobile, Email, HomeTown, Service,Blood);

                    databaseReference.child(Id).setValue(info);






                    Toast.makeText(Modify_info.this, "Submited Successfully.", Toast.LENGTH_SHORT).show();

                    name.setText("");
                    id.setText("");
                    mobile.setText("");
                    email.setText("");
                    homeTown.setText("");
                    service.setText("");



                    Intent intent = new Intent(Modify_info.this,MainActivity.class);
                    startActivity(intent);


                }






            }


        });


    }

    public void mofifyBackID (View view){
        Intent intent ;
        if (view.getId()==R.id.modifyInfoBackID){
            intent = new Intent(Modify_info.this,afterStudent.class);
            startActivity(intent);
        }
    }

}