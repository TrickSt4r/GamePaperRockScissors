package com.example.maste2seven.weightcheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Maste2seven on 3/2/2559.
 */
public class MyManage {

    //explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase; //คำสั่งให้เขียนและอ่าน

    public static final String table_User = "userTable";
    public static final String table_Weight = "weightTable";
    public static final String colum_id = "id";
    public static final String colum_user = "user";
    public static final String colum_password = "password";
    public static final String colum_Name = "name";
    public static final String colum_Date = "date";
    public static final String colum_weight = "weight";

    public MyManage(Context context) {

        //create & connected
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }//construtoc
    //add new value
    public long addUserTable(String strUser,String strPassword,String strName) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(colum_user,strUser);
        objContentValues.put(colum_password,strPassword);
        objContentValues.put(colum_Name,strName);

        return writeSqLiteDatabase.insert(table_User, null, objContentValues);
    }

}//main classz

