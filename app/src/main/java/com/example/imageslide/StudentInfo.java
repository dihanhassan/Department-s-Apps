package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
    }

    public void toolbarBack (View view){
        Intent intent = new Intent(StudentInfo.this,afterStudent.class);
        startActivity(intent);
    }
    public void showStudent (View view){
           Intent intent;
           intent = new Intent(StudentInfo.this,showInfo.class);
           if (view.getId()==R.id.cardView_1_ID){
                intent.putExtra("tag","2003-4");
                startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_2_ID){
               intent.putExtra("tag","2004-5");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_3_ID){
               intent.putExtra("tag","2005-6");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_4_ID){
               intent.putExtra("tag","2006-7");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_5_ID){
               intent.putExtra("tag","2007-8");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_6_ID){
               intent.putExtra("tag","2008-9");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_7_ID){
               intent.putExtra("tag","2009-10");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_8_ID){
               intent.putExtra("tag","2010-11");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_9_ID){
               intent.putExtra("tag","2011-12");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_10_ID){
               intent.putExtra("tag","2012-13");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_11_ID){
               intent.putExtra("tag","2013-14");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_12_ID){
               intent.putExtra("tag","2014-15");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_13_ID){
               intent.putExtra("tag","2015-16");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_14_ID){
               intent.putExtra("tag","2016-17");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_15_ID){
               intent.putExtra("tag","2017-18");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_16_ID){
               intent.putExtra("tag","2018-19");
               startActivity(intent);
            }
            else if (view.getId()==R.id.cardView_17_ID){
               intent.putExtra("tag","2019-20");
               startActivity(intent);
            }
           else if (view.getId()==R.id.cardView_18_ID){
               intent.putExtra("tag","2020-21");
               startActivity(intent);
           }

    }

}