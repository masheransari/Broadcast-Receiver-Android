package com.example.asheransari.broadcastreciever1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asher.ansari on 6/29/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABSE_NAME = "numberDb";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "create table "+DBContract.TABLE_NAME+
            "( id integer primary key autoincrement, "+DBContract.INCOMING_NUMBER+" text);";
    private static final String DROP_TABLE = "drop table if exists "+DBContract.TABLE_NAME;


    public DBHelper(Context context) {
        super(context,DATABSE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void saveNumber(String number, SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put(DBContract.INCOMING_NUMBER,number);
        database.insert(DBContract.TABLE_NAME,null, values);
    }
    public Cursor readNumber(SQLiteDatabase database){
        String[] numbers = {"id",DBContract.INCOMING_NUMBER};
        return (database.query(DBContract.TABLE_NAME,numbers,null,null,null,null,null));
    }
}
