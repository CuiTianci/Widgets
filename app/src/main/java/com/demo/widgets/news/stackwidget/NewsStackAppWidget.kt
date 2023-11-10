package com.demo.widgets.news.stackwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.PendingIntentCompat
import com.demo.widgets.R
import com.demo.widgets.dLog
import com.demo.widgets.ui.NewsDetailsActivity

/**
 * Implementation of App Widget functionality.
 */
class NewsStackAppWidget : AppWidgetProvider() {

    private companion object {
        private const val TAG = "NewsStackAppWidget"
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        "onUpdated".dLog(TAG)
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        "onEnabled".dLog(TAG)
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
        "onDisabled".dLog(TAG)
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
    ) {
        val intent = Intent(context, NewsStackWidgetService::class.java)
        val rv = RemoteViews(context.packageName, R.layout.news_stack_app_widget).apply {
            setRemoteAdapter(R.id.stack, intent)
            setEmptyView(R.id.stack, R.id.tvEmpty)
        }
        val pi = PendingIntentCompat.getActivity(
            context,
            appWidgetId, /* TODO Request Code*/
            Intent(context, NewsDetailsActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT,
            true,
        )
        rv.setPendingIntentTemplate(R.id.stack, pi)
        appWidgetManager.updateAppWidget(appWidgetId, rv)
    }
}
