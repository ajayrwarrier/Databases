package com.example.ajayrwarrier.databases.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class HabbitDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pets.db";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE " + HabbitContract.HabbitEntry.TABLE_NAME;
    private static int DB_VERSION = 1;
    String SQL_CREATE_HABBITS_TABLE = "CREATE TABLE " + HabbitContract.HabbitEntry.TABLE_NAME + " ("
            + HabbitContract.HabbitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabbitContract.HabbitEntry.COLUMN_HABBIT_NAME + " TEXT NOT NULL, "
            + HabbitContract.HabbitEntry.COLUMN_HABBIT_HOURS + "INTEGER);";

    public HabbitDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_HABBITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}