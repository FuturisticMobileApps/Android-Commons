package com.futuristicmobilieapps.commons.extensions.android.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.getSystemService

fun Context.isOnline(): Boolean {
    val connectivityManager = getSystemService<ConnectivityManager>()
    return connectivityManager?.isCurrentlyConnected() ?: false
}