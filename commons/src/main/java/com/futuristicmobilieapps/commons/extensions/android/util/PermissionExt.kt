package com.futuristicmobilieapps.commons.extensions.android.util

import android.app.Activity
import android.os.Build
import androidx.activity.result.ActivityResultLauncher

typealias PermissionLauncher = ActivityResultLauncher<String>

fun Activity.showcheckPermission(
    isGranted: Boolean = false,
    permission: String,
    permissionGranted: () -> Unit
) {
    if (isGranted && Build.VERSION.SDK_INT > 30) {
        permissionGranted()
        return
    }
    if (!shouldShowRequestPermissionRationale(permission)) {

        showPermissionDeniedDialog(true,permission)

    } else {

        showPermissionDeniedDialog(permission = permission)

    }
}
fun Activity.showcheckPermission(
    allGranted: Boolean = false,
    permissions: Array<String>,
    permissionGranted: () -> Unit
) {
    if (allGranted && Build.VERSION.SDK_INT > 30) {
        permissionGranted()
        return
    }
    if (permissions.any {!shouldShowRequestPermissionRationale(it)}) {

        showPermissionDeniedDialog(true)

    }else {

        showPermissionDeniedDialog()
    }
}



