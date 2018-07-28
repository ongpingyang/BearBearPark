package com.example.pingyangong.bearbearpark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mydata.db";
    public static final String TABLE_NAME = "mydata";
    public static final String COL1 = "ID";
    public static final String COL2 = "HOUR";
    public static final String COL3 = "MIN";
    public static final String COL4 = "LAT";
    public static final String COL5 = "LONG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "HOUR TEXT ," + "MIN TEXT ," + "BARCODE TEXT ," + "LAT TEXT ," + "LONG TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
    }

    public boolean addTime (String hour, String min){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,hour);
        long result = db.insert(TABLE_NAME,null,contentValues);

        contentValues.put(COL3,min);
        long result1 = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addLat (String latitude){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4,latitude);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addLong (String longitude){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5,longitude);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }
}
