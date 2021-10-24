package com.mika.parcial20

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class MIWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val N = appWidgetIds.size
        for (i in 0 until N) {
            val appWidgetId = appWidgetIds[i]
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            val views = RemoteViews(context.packageName, R.layout.mi_widget_note)
            views.setOnClickPendingIntent(R.id.abrirapp, pendingIntent)
            val mdformat = SimpleDateFormat("HH:mm:ss")
            val strDate = mdformat.format(Calendar.getInstance().time)
            views.setTextViewText(R.id.textwid, strDate)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}