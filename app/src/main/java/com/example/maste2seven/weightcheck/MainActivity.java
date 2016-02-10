package com.example.maste2seven.weightcheck;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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


        //checkregister
        checkRegister();

    }//main method

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




