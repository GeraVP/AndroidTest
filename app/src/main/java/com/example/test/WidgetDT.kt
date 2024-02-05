package com.example.test

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

/**
 * Implementation of App Widget functionality.
 */
class WidgetDT : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

       // val views = RemoteViews(context.packageName, R.layout.widget_d_t)

        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val dbHelper = MyDBManager(context)
    val data = dbHelper.readWidget()[5]

    //val views = RemoteViews(context.packageName, R.layout.widget_d_t)
    val views = RemoteViews(context.packageName,R.layout.widget_d_t)
    views.setTextViewText(R.id.textView, data.toString())

    //views.setRemoteAdapter(R.id.lv,)

    appWidgetManager.updateAppWidget(appWidgetId, views)

}