package com.example.nawafalzahem_mid2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="HumansDB";
    private static final String TABLE_NAME="Person";
    private static final String COLUMN_ID="ID";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_EMAIL="Email";
    private static final String COLUMN_PHONE="Phone";
    private static final String COLUMN_PERSONALID="PID";
    SQLiteDatabase db;

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS " +TABLE_NAME+"("
                + COLUMN_ID+" INTEGER PRIMARY KEY,"
                + COLUMN_NAME+" TEXT NOT NULL,"
                +COLUMN_EMAIL+" TEXT NOT NULL,"
                +COLUMN_PHONE+" TEXT NOT NULL,"
                +COLUMN_PERSONALID+" TEXT NOT NULL)"
        );

    }

    public boolean insert(String ID,String Name ,String Email ,String Phone ,String PID ){
        db=getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COLUMN_ID,ID);
        contentValues.put(COLUMN_NAME,Name);
        contentValues.put(COLUMN_EMAIL,Email);
        contentValues.put(COLUMN_PHONE,Phone);
        contentValues.put(COLUMN_PERSONALID,PID);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result!=-1){
            return true;
        }
        else{
            return false;
        }


    }

    public Cursor getSpecificResult(String id){
        db=getReadableDatabase();
        Cursor data =db.rawQuery(" SELECT * FROM  "+TABLE_NAME+" WHERE ID= ?",new String[]{id});

        if (data != null)
            data.moveToFirst();
        return data;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Cursor getFirstRow(){
        db=getReadableDatabase();
        Cursor data= db.rawQuery("SELECT *  FROM "+TABLE_NAME +" LIMIT 1" ,null);
        if (data != null)
            data.moveToFirst();
        return data;
    }

    public Cursor deleteFirstRow(){
        db=getReadableDatabase();
        Cursor data= db.rawQuery("DELETE FROM " +TABLE_NAME + " WHERE ID IN (SELECT ID FROM "+ TABLE_NAME+" LIMIT 1)"
                ,null);
        if (data != null)
            data.moveToFirst();
        return data;
    }
}
