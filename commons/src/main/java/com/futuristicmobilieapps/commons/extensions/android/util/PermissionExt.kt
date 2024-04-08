package com.futuristicmobilieapps.commons.extensions.android.util

import android.app.Activity
import android.os.Build
import androidx.activity.result.ActivityResultLauncher

typealias PermissionLauncher = ActivityResultLauncher<String>

fun Activity.checkRuntimePermission(
    isGranted: Boolean = false,
    permission: String,
    permissionGranted: () -> Unit
) {
    if (isGranted && Build.VERSION.SDK_INT > 30) {
        permissionGranted()
        return
    }
    if (!shouldShowRequestPermissionRationale(permission)) {

        showPermissionDeniedDialog(permission)

    } else {

        showPermissionDeniedDialog(permission = permission)

    }
}

fun Activity.checkArrayOfPermissions(
    allGranted: Boolean = false,
    permissions: Array<String>,
    permissionGranted: () -> Unit
) {
    if (allGranted && Build.VERSION.SDK_INT > 30) {
        permissionGranted()
        return
    }

    val deniedPermissions = permissions.filter {
        !isPermissionGranted(it)
    }

    if (deniedPermissions.isNotEmpty()) {
        for (permission in deniedPermissions) {
            showPermissionDeniedDialog(permission)
        }
    } else {
        permissionGranted()
    }
}

fun Activity.isPermissionGranted(permission: String): Boolean {

    return checkSelfPermission(permission) == android.content.pm.PackageManager.PERMISSION_GRANTED
}


