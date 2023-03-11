package com.example.practice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseContact extends SQLiteOpenHelper {
    public DatabaseContact(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private final String TABLE_NAME = "Contact";
    private final String CONTACT_ID = "ID";
    private final String CONTACT_NAME = "Name";
    private final String CONTACT_IMAGE = "Image";
    private final String CONTACT_PHONE = "Phone Number";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + CONTACT_ID + " TEXT PRIMARY KEY, "
                + CONTACT_NAME + " TEXT, " + CONTACT_PHONE + " TEXT, " + CONTACT_IMAGE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add
    //
}
