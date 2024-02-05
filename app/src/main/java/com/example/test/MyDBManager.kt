package com.example.test

import android.app.LauncherActivity.ListItem
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import java.text.SimpleDateFormat
import java.util.Date


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
    fun readWidget(): ArrayList<String>{
        openDv()

        val format = SimpleDateFormat("dd/M/yyyy")
        val dt = format.format(Date())

        val dataList = ArrayList<String>()
        val selection = "${MyDBNameClass.column1} like ?"
        val cursor = db?.query(MyDBNameClass.tablename,null,null, null,null,null,null)

        while (cursor?.moveToNext()!!)
        {
            val dataT = cursor.getString(cursor.getColumnIndexOrThrow(MyDBNameClass.column1))
            dataList.add(dataT + dt.toString())
        }
        cursor.close()
        return dataList
    }
    fun closedb(){
        myDbHelper.close()
    }
}