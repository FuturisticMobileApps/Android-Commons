package com.futuristicmobilieapps.commons.extensions.android.view

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.futuristicmobilieapps.commons.extensions.android.util.getColorFromResId
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.android.util.tryCatch
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


fun Fragment.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    if (isAdded) requireActivity().snack(resourceId, duration, actionMessage, listener)
}


fun Fragment.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    if (isAdded) requireActivity().snack(message, duration, actionMessage, listener)
}

fun DialogFragment.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    if (isAdded) dialog?.window?.decorView?.snack(resourceId, duration, actionMessage, listener)
}


fun DialogFragment.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    if (isAdded) dialog?.window?.decorView?.snack(message, duration, actionMessage, listener)
}

fun Dialog.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    window?.decorView?.snack(resourceId, duration, actionMessage, listener)
}

fun Dialog.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    window?.decorView?.snack(message, duration, actionMessage, listener)
}

fun View.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    snack(context.getStringResources(resourceId), duration, actionMessage, listener)
}


fun Context.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    snack(getStringResources(resourceId), duration, actionMessage, listener)
}

fun View.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    make(message, duration, actionMessage, listener)
}

fun Context.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    val rootView: View? = (this as? Activity)?.findViewById(android.R.id.content)

    rootView?.make(message, duration, actionMessage, listener) ?: toast(message, duration)
}

fun View.make(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {

    message ?: return

    tryCatch(
        onCatch = { context.toast(message) }
    ) {

        val snackBar = Snackbar.make(this, message, duration.validateSnackBarDuration())
            .setAction(actionMessage, listener)

        with(snackBar.view) {

            findViewById<TextView>(com.google.android.material.R.id.snackbar_text)?.maxLines = 20

            setOnClickListener { snackBar.dismiss() }

            setBackgroundColor(context.getColorFromResId(androidx.appcompat.R.color.primary_dark_material_dark))
        }

        snackBar.setTextColor(context.getColorFromResId(com.google.android.material.R.color.primary_material_light))

        snackBar.setActionTextColor(context.getColorFromResId(androidx.appcompat.R.color.primary_material_light))

        snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE

        snackBar.show()

    }

}

fun Int?.validateSnackBarDuration(): Int =
    this?.takeIf { it == Snackbar.LENGTH_SHORT || it == Snackbar.LENGTH_LONG || it == Snackbar.LENGTH_INDEFINITE }
        ?: Snackbar.LENGTH_SHORT





