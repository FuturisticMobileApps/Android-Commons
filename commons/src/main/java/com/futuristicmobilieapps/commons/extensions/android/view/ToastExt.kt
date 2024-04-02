package com.futuristicmobilieapps.commons.extensions.android.view

import android.app.Dialog
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString

private const val LENGTH_SHORT = Toast.LENGTH_SHORT
private const val LENGTH_LONG = Toast.LENGTH_LONG

fun Int.validateToastDuration() =
    if (this == LENGTH_SHORT || this == LENGTH_LONG) this else Toast.LENGTH_SHORT

fun Fragment.toast(resourcesId: Int, duration: Int = LENGTH_SHORT) {
    requireContext().toast(resourcesId, duration)
}

fun Fragment.toast(message: String?, duration: Int = LENGTH_SHORT) {
    requireContext().toast(message, duration)
}

fun Dialog.toast(resourcesId: Int, duration: Int = LENGTH_SHORT) {
    context.toast(resourcesId, duration)
}

fun Dialog.toast(message: String?, duration: Int = LENGTH_SHORT) {
    context.toast(message, duration)
}

fun Context.toast(resourcesId: Int, duration: Int = LENGTH_SHORT) {
    toast(getStringResources(resourcesId), duration)
}

fun Context.toast(message: String?, duration: Int = LENGTH_SHORT) {
    if (message.isValidString())
        Toast.makeText(this, message, duration.validateToastDuration()).show()
}

