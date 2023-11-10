package com.demo.widgets.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.PendingIntentCompat
import androidx.core.util.SizeFCompat
import androidx.core.widget.updateAppWidget
import com.demo.widgets.NewsEntity
import com.demo.widgets.R
import com.demo.widgets.dLog
import com.demo.widgets.newsList
import com.demo.widgets.ui.NewsDetailsActivity

/**
 * Implementation of App Widget functionality.
 */
class NewsAppWidget : AppWidgetProvider() {

    private companion object {
        private const val TAG = "NewsAppWidget"
        private const val TOP_NEWS_INDEX: Int = 0
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        "onUpdate".dLog(TAG)
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
        // Instruct the widget manager to update the widget
        val supportedSizes = listOf(
            SizeFCompat(140.0f, 110.0f),
            SizeFCompat(270.0f, 110.0f),
            SizeFCompat(140.0f, 250.0f),
            SizeFCompat(270.0f, 250.0f),
        )
        appWidgetManager.updateAppWidget(appWidgetId, supportedSizes) {
            val remoteView: RemoteViews
            when (it) {
                supportedSizes[0] -> {
                    remoteView = RemoteViews(context.packageName, R.layout.news_app_widget_small)
                    populateTopNews(remoteView, false)
                }

                supportedSizes[1] -> {
                    remoteView = RemoteViews(context.packageName, R.layout.news_app_widget_wide)
                    populateTopNews(remoteView)
                }

                supportedSizes[2] -> {
                    remoteView = RemoteViews(context.packageName, R.layout.news_app_widget_tall)
                    populateTopNews(remoteView)
                    setRecommendClickListener(context, remoteView)
                }

                else -> {
                    remoteView = RemoteViews(context.packageName, R.layout.news_app_widget_large)
                    populateTopNews(remoteView)
                    populateRecommendedNews(remoteView)
                    setRecommendClickListener(context, remoteView)
                }
            }
            setWidgetClickListener(context, remoteView)
            remoteView
        }
    }

    private val topNewsEntity: NewsEntity get() = newsList[TOP_NEWS_INDEX]

    private fun populateTopNews(rv: RemoteViews, withContent: Boolean = true) {
        val topNews = topNewsEntity
        rv.setTextViewText(R.id.tvTitle, topNews.title)
        rv.setImageViewResource(R.id.item_news_in_collection, topNews.imageId)
        if (withContent) rv.setTextViewText(R.id.tvContent, topNews.content)
    }

    private fun populateRecommendedNews(rv: RemoteViews) {
        val recommendedNews = newsList.filterIndexed { index, _ ->
            index != TOP_NEWS_INDEX
        }
        rv.setTextViewText(R.id.tvRecommend0, recommendedNews[0].title)
        rv.setTextViewText(R.id.tvRecommend1, recommendedNews[1].title)
        rv.setTextViewText(R.id.tvRecommend2, recommendedNews[2].title)
        rv.setTextViewText(R.id.tvRecommend3, recommendedNews[3].title)
    }

    private fun setWidgetClickListener(context: Context, rv: RemoteViews) {
        val pi = getPendingIntentByIndex(context, TOP_NEWS_INDEX, android.R.id.background)
        rv.setOnClickPendingIntent(android.R.id.background, pi)
    }

    private fun setRecommendClickListener(context: Context, rv: RemoteViews) {
        val recommendedViewIds = listOf(
            R.id.tvRecommend0,
            R.id.tvRecommend1,
            R.id.tvRecommend2,
            R.id.tvRecommend3,
        )
        val recommendedNews = newsList.filterIndexed { index, _ ->
            index != TOP_NEWS_INDEX
        }
        recommendedViewIds.forEachIndexed { i, id ->
            val newsIndex = newsList.indexOf(recommendedNews[i])
            val pi = getPendingIntentByIndex(context, newsIndex, id)
            rv.setOnClickPendingIntent(id, pi)
        }
    }

    private fun getPendingIntentByIndex(
        context: Context,
        index: Int,
        requestCode: Int,
    ): PendingIntent {
        val intent = Intent(context, NewsDetailsActivity::class.java)
        intent.putExtra(NewsDetailsActivity.EXTRA_NEWS_INDEX, index)
        return PendingIntentCompat.getActivity(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT,
            true,
        )
    }
}
