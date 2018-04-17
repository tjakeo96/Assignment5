package com.example.jacobnewberry.ptcmanagement;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    //version #
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_NAME = "crud.db";

    //constructor
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the tables

        String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + customersTable.TABLE  + "("
                + customersTable.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + customersTable.KEY_name + " TEXT, "
                + customersTable.KEY_phone + " Text )";


        db.execSQL(CREATE_TABLE_CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + customersTable.TABLE);

        // Create tables again
        onCreate(db);

    }
}
