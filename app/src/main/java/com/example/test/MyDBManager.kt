package com.example.test

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDBManager(context: Context) {
val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null
    fun openDv(){
        db = myDbHelper.writableDatabase
    }
    fun insertToDb (Contentd:String){
        val values = ContentValues().apply {
            put(MyDBNameClass.column1,Contentd)
        }
        db?.insert(MyDBNameClass.tablename,null,values)
    }
    fun readdbdata():ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyDBNameClass.tablename,null,null,null,null,null,null)
        while(cursor?.moveToNext()!!){
            val dataContent = cursor.getString(cursor.getColumnIndexOrThrow(MyDBNameClass.column1))
            dataList.add(dataContent)
        }
        return dataList
    }
    fun closedb(){
        myDbHelper.close()
    }
}