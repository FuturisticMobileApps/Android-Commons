package com.futuristicmobilieapps.commons.extensions.android.util

import android.content.Context

fun Context.getStringResources(stringId: Int?) = tryCatch("") {
    stringId?.let { resources.getString(it) } ?: ""
}