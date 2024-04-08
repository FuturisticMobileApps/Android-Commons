package com.futuristicmobilieapps.commons.extensions.android.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.futuristicmobilieapps.views.dialogs.CommonAlertDialog

fun Activity.showPermissionDeniedDialog(permission: String) {
    val isPermanentlyDenied = !shouldShowRequestPermissionRationale(permission)
    CommonAlertDialog(
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


 fun Context.openAppSettings(){
     Log.i("check", "openAppSettings: settings")
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName"))
    startActivity(intent)
}