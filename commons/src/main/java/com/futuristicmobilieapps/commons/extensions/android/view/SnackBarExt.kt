package com.futuristicmobilieapps.commons.extensions.android.view

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Fragment.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    requireActivity().snack(resourceId, duration, actionMessage, listener)
}


fun Fragment.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    requireActivity().snack(message, duration, actionMessage, listener)
}


fun BottomSheetDialogFragment.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    dialog?.window?.decorView?.snack(resourceId, duration, actionMessage, listener)
}


fun BottomSheetDialogFragment.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    dialog?.window?.decorView?.snack(message, duration, actionMessage, listener)
}

fun AppCompatDialogFragment.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    dialog?.window?.decorView?.snack(resourceId, duration, actionMessage, listener)
}


fun AppCompatDialogFragment.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    dialog?.window?.decorView?.snack(message, duration, actionMessage, listener)
}


fun View.snack(
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {

    make(context.getStringResources(resourceId), duration, actionMessage, listener)

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
    resourceId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {

    val view: View = (this as? Activity)?.findViewById(android.R.id.content)!!

    view.make(view.context.getStringResources(resourceId), duration, actionMessage, listener)

}


fun Context.snack(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {

    val view: View = (this as? Activity)?.findViewById(android.R.id.content)!!

    view.make(message, duration, actionMessage, listener)

}


fun View.make(
    message: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMessage: String? = null,
    listener: ((View) -> Unit)? = null
) {
    message ?: return

    val snackBar = Snackbar.make(this, message, duration.validateSnackBarDuration())

        .setAction(actionMessage, listener)

    snackBar.view.apply {

        findViewById<TextView>(com.google.android.material.R.id.snackbar_text)?.maxLines = 20

        setOnClickListener { snackBar.dismiss() }

        setBackgroundColor(ContextCompat.getColor(context, androidx.appcompat.R.color.primary_dark_material_dark))
    }

    snackBar.setTextColor(ContextCompat.getColor(context, com.google.android.material.R.color.primary_material_light))

    snackBar.setActionTextColor(ContextCompat.getColor(context, androidx.appcompat.R.color.primary_material_light))

    snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE

    snackBar.show()
}


fun Int?.validateSnackBarDuration(): Int {

    return this?.takeIf { it == Snackbar.LENGTH_SHORT || it == Snackbar.LENGTH_LONG || it == Snackbar.LENGTH_INDEFINITE }

        ?: Snackbar.LENGTH_SHORT
}




