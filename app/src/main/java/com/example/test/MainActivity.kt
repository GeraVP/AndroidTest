package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val yDBManager = MyDBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yDBManager.openDv()
        yDBManager.insertToDb("привет")
        val datalist = yDBManager.readdbdata()

        //var tvT
        val tv = findViewById<TextView>(R.id.textvier)
        val tvk = "yDBManager.readdbdata()[0]"
            //yDBManager.readdbdata()[1]
        tv.text = tvk
       /* for(item in datalist){
            tv.append(item)
            tv.append("\n")
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        yDBManager.closedb()
    }

}