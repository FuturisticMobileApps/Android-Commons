package com.futuristicmobilieapps.commons.extensions.kotlin

import android.content.Context

fun Context.getStringResources(stringId: Int?)= stringId?.let { resources.getString(it) } ?: ""