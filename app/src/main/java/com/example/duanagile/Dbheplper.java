package com.example.duanagile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbheplper extends SQLiteOpenHelper {

    private static final String DB_NAME = "snackmini.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_USER = "users";

    public Dbheplper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable = "CREATE TABLE " + TABLE_USER + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email TEXT UNIQUE, " +
                "password TEXT, " +
                "full_name TEXT, " +
                "role TEXT, " +
                "status INTEGER" +
                ")";

        db.execSQL(createUserTable);


        ContentValues admin = new ContentValues();
        admin.put("email", "admin@gmail.com");
        admin.put("password", "123456");
        admin.put("full_name", "Administrator");
        admin.put("role", "ADMIN");
        admin.put("status", 1);

        db.insert(TABLE_USER, null, admin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }


    public boolean registerUser(String email, String password, String fullName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        values.put("full_name", fullName);
        values.put("role", "CUSTOMER");
        values.put("status", 1);

        long result = db.insert(TABLE_USER, null, values);
        return result != -1;
    }


    public Cursor login(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM " + TABLE_USER +
                        " WHERE email=? AND password=? AND status=1",
                new String[]{email, password}
        );
    }


    public boolean checkEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT id FROM " + TABLE_USER + " WHERE email=?",
                new String[]{email}
        );

        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }
}
