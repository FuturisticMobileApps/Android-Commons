package com.futuristicmobilieapps.commons.extensions.android.util

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat

fun Context.getStringResources(stringId: Int?) = tryCatch("") {
    stringId?.let { resources.getString(it) } ?: ""
}

fun Context.getColorFromResId(colorResId: Int): Int = tryCatch(Color.TRANSPARENT) {
    ContextCompat.getColor(this, colorResId)
}

