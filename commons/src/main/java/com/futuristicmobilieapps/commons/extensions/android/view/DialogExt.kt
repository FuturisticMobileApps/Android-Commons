package com.futuristicmobilieapps.commons.extensions.android.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.kotlin.validateBoolean

fun AppCompatDialogFragment.onLoadDialog(
    isFullScreen: Boolean = true,
    isAutoCancel: Boolean = true
): Dialog {

    return Dialog(requireContext(), R.style.DialogFragmentStyle).apply {

        val widthHeight =
            if (isFullScreen) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT

        setContentView(

            LinearLayout(requireContext()).apply {

                layoutParams = ViewGroup.LayoutParams(widthHeight, widthHeight)
            }
        )

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        window?.setLayout(widthHeight, widthHeight)

        isCancelable = isAutoCancel

        setCanceledOnTouchOutside(isAutoCancel)
    }
}

fun AppCompatDialogFragment.showDialog(fragmentManager: FragmentManager, tag: String) {

    val fragment = fragmentManager.findFragmentByTag(tag)

    if (!fragment?.isAdded.validateBoolean()) show(fragmentManager, tag)
}

fun AppCompatDialogFragment.showDialog(activity: AppCompatActivity, tag: String) {

    showDialog(activity.supportFragmentManager, tag)
}

fun AppCompatDialogFragment.showDialog(activity: FragmentActivity, tag: String) {

    showDialog(activity.supportFragmentManager, tag)
}

fun TextView.setTextForTextView(input: String?) {

    text = input

}