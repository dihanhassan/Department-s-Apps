package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BugReport extends AppCompatActivity {
    EditText id,bugText;
    Button submit;
    DatabaseReference databaseReference ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_report);
        
        id = (EditText) findViewById(R.id.bugId);
        bugText = (EditText) findViewById(R.id.bugText);
        
        submit = (Button) findViewById(R.id.Bug_submitID);
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id = id.getText().toString().trim();
                String BugText = bugText.getText().toString().trim();
                
                if (Id.isEmpty() || BugText.isEmpty()){
                    Toast.makeText(BugReport.this, "Please Fill Properly.", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference = FirebaseDatabase.getInstance().getReference("Bug Reports");
                    dataHolderForBugReport info = new dataHolderForBugReport(Id,BugText);
                    databaseReference.child(Id).setValue(info);
                    Toast.makeText(BugReport.this, "Submited Successfully.", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    bugText.setText("");

                }
            }
        });
        

    }



    

    public void BugReportBackID (View view){
        Intent intent ;
        if (view.getId()==R.id.BugBackID){
            intent = new Intent(BugReport.this,More.class);
            startActivity(intent);
        }
    }
}