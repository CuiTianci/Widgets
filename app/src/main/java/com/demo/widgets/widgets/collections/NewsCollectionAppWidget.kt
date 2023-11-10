package com.demo.widgets.widgets.collections

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.annotation.LayoutRes
import androidx.core.app.PendingIntentCompat
import com.demo.widgets.R
import com.demo.widgets.dLog
import com.demo.widgets.getIntSp
import com.demo.widgets.ui.NewsDetailsActivity

/**
 * Implementation of App Widget functionality.
 */
class NewsCollectionAppWidget : AppWidgetProvider() {

    companion object {
        private const val TAG = "NewsStackAppWidget"

        @LayoutRes
        private fun getLayoutId(context: Context): Int {
            val collectionTypeSp = context.getIntSp(CollectionType.SP_KEY)
            val collectionType = CollectionType.valueOf(collectionTypeSp) ?: CollectionType.DEFAULT
            return when (collectionType) {
                CollectionType.STACK -> R.layout.news_collection_widget_stack
                CollectionType.FLIPPER -> R.layout.news_collection_widget_flipper
                CollectionType.LIST -> R.layout.news_collection_widget_list_view
                CollectionType.GRID -> R.layout.news_collection_widget_grid_view
            }
        }

        fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int,
        ) {
            val intent = Intent(context, NewsCollectionWidgetService::class.java)
            val rv = RemoteViews(context.packageName, getLayoutId(context)).apply {
                setRemoteAdapter(R.id.collectionView, intent)
                setEmptyView(R.id.collectionView, R.id.tvEmpty)
            }
            val pi = PendingIntentCompat.getActivity(
                context,
                appWidgetId, /* TODO Request Code*/
                Intent(context, NewsDetailsActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT,
                true,
            )
            rv.setPendingIntentTemplate(R.id.collectionView, pi)
            appWidgetManager.updateAppWidget(appWidgetId, rv)
        }
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
}
