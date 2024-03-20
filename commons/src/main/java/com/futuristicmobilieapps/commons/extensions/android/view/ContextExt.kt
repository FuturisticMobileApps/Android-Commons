package com.futuristicmobilieapps.commons.extensions.android.view

import android.content.Context

fun Context.getStringResources(stringId: Int?)= stringId?.let { resources.getString(it) } ?: ""