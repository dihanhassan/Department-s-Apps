package com.example.imageslide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOtp extends AppCompatActivity {
    public static int ok = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);



        // check the Activity Running for First Time Only

        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);

        String FristTime = preferences.getString("FirstTimeInstall","");

        if (FristTime.equals("Yes")){
            Intent intent = new Intent(SendOtp.this,MainActivity.class);
            startActivity(intent);
        }

        final EditText inputMobile = findViewById(R.id.inputMobile);
        Button buttonGetOTP = findViewById(R.id.buttonGetOTP);

        final ProgressBar progressBar = findViewById(R.id.progressBar);


        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(SendOtp.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);
                buttonGetOTP.setVisibility(view.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+880" + inputMobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        SendOtp.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(view.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(view.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                                Toast.makeText(SendOtp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(view.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(),VerifyOtp.class);
                                intent.putExtra("mobile",inputMobile.getText().toString());
                                intent.putExtra("verificaitonID",verificationID);
                                startActivity(intent);
                            }
                        }
                );


            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Are you want to Exit ? ")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        SendOtp.super.onBackPressed();
//                        finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
//
//    }

}