package com.demo.widgets

import android.util.Log

fun String.dLog(tag: String) {
    Log.d("widgets:$tag", this)
}
