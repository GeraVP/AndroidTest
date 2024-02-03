package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val yDBManager = MyDBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yDBManager.openDv()
        yDBManager.insertToDb("trteeg")
        val datalist = yDBManager.readdbdata()

        //var tvT
        val tv = findViewById<TextView>(R.id.textvier)
        for(item in datalist){
            tv.append(item)
            tv.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        yDBManager.closedb()
    }
}