package com.example.maste2seven.weightcheck;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //expicit
    private MyManage objMyManage;
    private EditText userEditText,passwordEditText;
    private Button loginbutton;
    private String userString, passwordString;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //bind Wiget ตัวแปรที่ประกาศกับ wiget ที่อยู่ใน layout
        bindWidget();

        //requestdatabase
        objMyManage = new MyManage(this);

        //button controller
        buttonController();

        //checkregister
        checkRegister();

    }//main method

    private void buttonController() {

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getvalue from EditText
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                //check space
                if (userString.equals("") || passwordString.equals("")) {
                    //have space
                    Toast.makeText(MainActivity.this, "มีช่องว่าง", Toast.LENGTH_SHORT).show();

                } else {
                    // no space
                    checkUser();

                }//if else

            }//event
        });

    }//button controller

    private void checkUser() {

        //read data from sqlite
        SQLiteDatabase objSqLiteDatabase=openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE,null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.table_User,null);
        objCursor.moveToFirst();
        String trueUser = objCursor.getString(1);
        String truePassword = objCursor.getString(2);
        String truename = objCursor.getString(3);

        if (userString.equals(truename)) {


        }
        else {

            Toast.makeText(MainActivity.this,"Plase Insert User",Toast.LENGTH_SHORT).show();
        }


    }

    private void bindWidget() {

        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        loginbutton = (Button) findViewById(R.id.button2);



    }//binwidget

    private void checkRegister() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name, MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM userName", null);
        if (objCursor.getCount() == 0) {
            Intent objIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(objIntent);
        }
    objCursor.close();
    }
}//main class




