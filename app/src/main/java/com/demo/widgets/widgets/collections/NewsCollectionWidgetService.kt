package com.demo.widgets.widgets.collections

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.annotation.LayoutRes
import com.demo.widgets.R
import com.demo.widgets.dLog
import com.demo.widgets.getIntSp
import com.demo.widgets.newsList
import com.demo.widgets.ui.NewsDetailsActivity

class NewsCollectionWidgetService : RemoteViewsService() {

    private companion object {
        const val TAG = "NewsStackWidgetService"
    }

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        "onGetViewFactory".dLog(TAG)
        return NewsStackViewsFactory(this.application)
    }

    class NewsStackViewsFactory(
        private val context: Context,
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
            return RemoteViews(context.packageName, getLayoutId(context)).apply {
                setTextViewText(R.id.tvTitle, newsEntity.title)
                setImageViewResource(R.id.item_news_in_collection, newsEntity.imageId)
                val intent = Intent().apply {
                    putExtra(NewsDetailsActivity.EXTRA_NEWS_INDEX, position)
                }
                setOnClickFillInIntent(R.id.item_news_in_collection, intent)
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

        @LayoutRes
        private fun getLayoutId(context: Context): Int {
            val collectionTypeSp = context.getIntSp(CollectionType.SP_KEY)
            val collectionType = CollectionType.valueOf(collectionTypeSp) ?: CollectionType.DEFAULT
            return when (collectionType) {
                CollectionType.STACK, CollectionType.FLIPPER -> R.layout.item_news_in_collection
                CollectionType.LIST, CollectionType.GRID -> R.layout.item_news_in_collection_small
            }
        }
    }
}
