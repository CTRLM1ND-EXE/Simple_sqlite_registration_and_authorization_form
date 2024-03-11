package com.example.mainActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQLite extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "nmdt_base";
    private static final int DATABASE_VERSION = 2 ;


    public static   final  String TABLENAME = "tablename";
    public static final String ID = "ID";
    public static final String DATA_NAME = "Name";
    public static final String DATA_SURNMAE = "Surname";
    public static final String DATA_NUMBERPHONE = "Numberphone";
    public static final String DATA_PASSWORD = "Password";







    public DataBaseSQLite( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Создаем таблицу
        db.execSQL(" CREATE TABLE " + TABLENAME + "(" + ID + " INTEGER PRIMARY KEY, "
                + DATA_NAME + " TEXT, " + DATA_SURNMAE + " TEXT, " + DATA_NUMBERPHONE + " TEXT, "
                + DATA_PASSWORD + " TEXT " + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);

    }
}
