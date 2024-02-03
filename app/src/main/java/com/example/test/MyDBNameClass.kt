package com.example.test

import android.provider.BaseColumns

object MyDBNameClass: BaseColumns {
    const val tablename = "Gosty"
    const val column1 = "Name"

    const val dbversion = 1
    const val dbname = "MyLessonDB.db"

    const val SQL_CREATE_ENTRIES = "CREATE TABLE $tablename ($column1 TEXT )"//PRIMARY KEY
    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $tablename"
}