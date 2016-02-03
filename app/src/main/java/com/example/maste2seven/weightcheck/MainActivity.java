package com.example.maste2seven.weightcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //expicit
    private MyManage objMyManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //requestdatabase
        objMyManage = new MyManage(this);

    }//main method
}//main class
