package com.demo.widgets.widgets.collections

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.widgets.R
import com.demo.widgets.databinding.ActivityCollectionWidgetConfigBinding
import com.demo.widgets.getIntSp
import com.demo.widgets.saveIntSp

class CollectionWidgetConfigActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectionWidgetConfigBinding

    private val radioButtonIds = listOf(R.id.rbStack, R.id.rbFlipper, R.id.rbList, R.id.rbGrid)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectionWidgetConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val previous = CollectionType.valueOf(getIntSp(CollectionType.SP_KEY))
        binding.rg.check(getPreviousCheckedId(previous))
        binding.btnGo.setOnClickListener {
            val resultValue = Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            val checkIndex = radioButtonIds.indexOf(binding.rg.checkedRadioButtonId)
            saveIntSp(CollectionType.SP_KEY, checkIndex)
            val isNewlyAdded = previous == null
            val isChanged = previous?.value != checkIndex // 判断选择前后是否发生变化。
            if (isChanged) {
                val appWidgetManager = AppWidgetManager.getInstance(this)
                NewsCollectionAppWidget.updateAppWidget(this, appWidgetManager, appWidgetId)
                if (!isNewlyAdded) {
                    appWidgetManager.notifyAppWidgetViewDataChanged(
                        appWidgetId,
                        R.id.collectionView,
                    )
                }
                setResult(Activity.RESULT_OK, resultValue)
            } else {
                setResult(Activity.RESULT_CANCELED, resultValue)
            }
            finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val resultValue = Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        setResult(Activity.RESULT_CANCELED, resultValue)
        super.onBackPressed()
    }

    private fun getPreviousCheckedId(previous: CollectionType?): Int {
        return radioButtonIds[(previous ?: CollectionType.DEFAULT).value]
    }

    private val appWidgetId
        get() = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID,
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID
}
