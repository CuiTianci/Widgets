package com.demo.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.demo.widgets.databinding.ActivityMainBinding
import com.demo.widgets.widgets.NewsAppWidget
import com.demo.widgets.widgets.collections.NewsCollectionAppWidget

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddNewsWidget.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                addWidget(NewsAppWidget::class.java)
            } else {
                toast("Pin app widget is not support by your device")
            }
        }
        binding.btnAddNewsCollectionsWidget.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                addWidget(NewsCollectionAppWidget::class.java)
            } else {
                toast("Pin app widget is not support by your device")
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addWidget(clazz: Class<out AppWidgetProvider>) {
        val appWidgetManager = AppWidgetManager.getInstance(this)
        val myProvider = ComponentName(this, clazz)
        if (appWidgetManager.isRequestPinAppWidgetSupported) {
            appWidgetManager.requestPinAppWidget(myProvider, null, null)
        } else {
            toast("Pin app widget is not support by your device")
        }
    }
}
