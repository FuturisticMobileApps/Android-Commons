package com.futuristicmobilieapps.commons.extensions.android.util

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.futuristicmobilieapps.views.dialogs.CommonDialog

fun Activity.showPermissionDeniedDialog(permission: String) {
    val isPermanentlyDenied = !shouldShowRequestPermissionRationale(permission)
    CommonDialog(
        title = "Permission Required",
        message = if (isPermanentlyDenied) {
            "You have denied the $permission permission many times. Please enable it from Settings."
        } else {
            "$permission Permission is required to access this feature. Kindly enable it."
        },
        positiveBtnText = if (isPermanentlyDenied) "Go to Settings" else "Ok",
        negativeBtnText = "Cancel",
        onClickPositiveBtn = {
            if (isPermanentlyDenied) {
                openAppSettings()
            }
        }
    ).show((this as FragmentActivity).supportFragmentManager, "permission_dialog")
}


