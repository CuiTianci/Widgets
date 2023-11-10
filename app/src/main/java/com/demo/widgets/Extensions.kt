package com.demo.widgets

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit

fun String.dLog(tag: String) {
    Log.d("widgets:$tag", this)
}

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

private const val SP_NAME = "com.demo.widgets.sp"

fun Context.getIntSp(key: String, default: Int = -1): Int {
    return getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getInt(key, default)
}

fun Context.saveIntSp(key: String, value: Int?) {
    getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit {
        if (value == null) {
            remove(key)
        } else {
            putInt(key, value)
        }
    }
}
