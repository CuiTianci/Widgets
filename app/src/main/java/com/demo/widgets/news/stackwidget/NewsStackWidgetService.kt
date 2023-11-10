package com.demo.widgets.news.stackwidget

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.demo.widgets.R
import com.demo.widgets.dLog
import com.demo.widgets.newsList
import com.demo.widgets.ui.NewsDetailsActivity

class NewsStackWidgetService : RemoteViewsService() {

    private companion object {
        const val TAG = "NewsStackWidgetService"
    }

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        "onGetViewFactory".dLog(TAG)
        return NewsStackViewsFactory(this.application, intent)
    }

    class NewsStackViewsFactory(
        private val context: Context,
        intent: Intent,
    ) : RemoteViewsFactory {

        private companion object {
            const val TAG = "NewsStackViewsFactory"
        }

        override fun onCreate() {
            "onCreate".dLog(TAG)
        }

        override fun onDataSetChanged() {
            "onDataSetChanged".dLog(TAG)
        }

        override fun onDestroy() {
            "onDestroy".dLog(TAG)
        }

        override fun getCount(): Int {
            "getCount".dLog(TAG)
            return newsList.size
        }

        override fun getViewAt(position: Int): RemoteViews {
            "getViewAt".dLog(TAG)
            val newsEntity = newsList[position]
            return RemoteViews(context.packageName, R.layout.item_news_in_stack).apply {
                setTextViewText(R.id.tvTitle, newsEntity.title)
                setImageViewResource(R.id.ivImg, newsEntity.imageId)
                val intent = Intent().apply {
                    putExtra(NewsDetailsActivity.EXTRA_NEWS_INDEX, position)
                }
                setOnClickFillInIntent(R.id.bg, intent)
            }
        }

        override fun getLoadingView(): RemoteViews? {
            "getLoadingView".dLog(TAG)
            return null // If null is returned, a default loading view will be used.
        }

        override fun getViewTypeCount(): Int {
            "getViewTypeCount".dLog(TAG)
            return 1
        }

        override fun getItemId(position: Int): Long {
            "getItemId".dLog(TAG)
            return newsList[position].imageId.toLong()
        }

        override fun hasStableIds(): Boolean {
            "hasStableIds".dLog(TAG)
            return true
        }
    }
}
