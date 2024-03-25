package com.futuristicmobilieapps.commons.extensions.android.util

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

@Suppress("DEPRECATION")
fun ConnectivityManager.isCurrentlyConnected() = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ->
        activeNetwork
            ?.let(::getNetworkCapabilities)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    else -> activeNetworkInfo?.isConnected
} ?: false


