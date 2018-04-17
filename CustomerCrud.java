package com.example.jacobnewberry.ptcmanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerCrud {

    //instantiate DBHelper
    private DBHelper dbHelper;

    //constructor
    public CustomerCrud(Context context){
        dbHelper = new DBHelper(context);
    }

    //method to insert customers
    public int insert(customersTable customer){
        //open connection
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(customersTable.KEY_name, customer.name);
        values.put(customersTable.KEY_phone, customer.phone);

        // Inserting Row
        long customer_Id = db.insert(customersTable.TABLE, null, values);
        db.close();
        return (int) customer_Id;

    }

    //method to delete customers
    public void delete(int customer_Id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(customersTable.TABLE, customersTable.KEY_ID + "= ?", new String[] { String.valueOf(customer_Id) });
        db.close();
    }

    //method to update customers
    public void update(customersTable customer) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(customersTable.KEY_name, customer.name);
        values.put(customersTable.KEY_phone, customer.phone);

        db.update(customersTable.TABLE, values, customersTable.KEY_ID + "= ?", new String[] { String.valueOf(customer.customer_ID) });
        db.close();
    }

    //method to create ArrayList
    public ArrayList<HashMap<String, String>> getCustomerList() {
        //Open read connection
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                customersTable.KEY_ID + "," +
                customersTable.KEY_name + "," +
                customersTable.KEY_phone + " FROM " + customersTable.TABLE;


        //create arraylist
        ArrayList<HashMap<String, String>> customersList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> customer = new HashMap<String, String>();
                customer.put("id", cursor.getString(cursor.getColumnIndex(customersTable.KEY_ID)));
                customer.put("name", cursor.getString(cursor.getColumnIndex(customersTable.KEY_name)));
                customersList.add(customer);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customersList;

    }


    //method to search by id
    public customersTable getCustomerById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                customersTable.KEY_ID + "," +
                customersTable.KEY_name + " FROM " + customersTable.TABLE + " WHERE "
                + customersTable.KEY_ID + "=?";


        int iCount =0;
        customersTable customer = new customersTable();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                customer.customer_ID =cursor.getInt(cursor.getColumnIndex(customersTable.KEY_ID));
                customer.name  =cursor.getString(cursor.getColumnIndex(customersTable.KEY_name));
                customer.phone  =cursor.getString(cursor.getColumnIndex(customersTable.KEY_phone));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customer;
    }
}
