package com.example.maste2seven.weightcheck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Maste2seven on 3/2/2559.
 */
public class MyManage {

    //explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase; //คำสั่งให้เขียนและอ่าน

    public MyManage(Context context) {

        //create & connected
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }//construtoc

}//main class

