package com.example.maste2seven.weightcheck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maste2seven on 3/2/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{


    //explicit
    public static final String database_name = "weight.db"; //ประกาศค่าคงที่ ไม่สามารถแก้ไขได้
    private static final int database_version = 1;
    private static final String table_weight = "create table weightTable(" +
            "_id integer primary key, " +
            "Date text, " +
            "weight text);";

    private static final String table_user = "create table userName(" +
            "_id primary key, " +
            "name text, " +
            "lastname text);";




    public MyOpenHelper(Context context) {
    super(context,database_name,null,database_version);
    //ทำการเชื่อมต่อ ค้นหาชื่อและตรวจสอบเวอร์ชั่น

    }//constrctor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(table_weight);
        sqLiteDatabase.execSQL(table_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}// mainclass
