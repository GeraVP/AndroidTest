package com.example.test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper(context,MyDBNameClass.dbname,null,MyDBNameClass.dbversion) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDBNameClass.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDBNameClass.SQL_DELETE_ENTRIES)
        onCreate(db)
    }}