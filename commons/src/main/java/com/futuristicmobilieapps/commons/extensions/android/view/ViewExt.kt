package com.futuristicmobilieapps.commons.extensions.android.view

import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.android.util.tryCatch
import com.google.android.material.textfield.TextInputLayout

fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View?.enable() {
    this?.isEnabled = true
}

fun View?.disable() {
    this?.isEnabled = false
}

fun View?.disableView(textInputLayout: TextInputLayout? = null) {
    this?.isEnabled = false

    textInputLayout?.apply {
        isEnabled = false
        boxBackgroundColor = ContextCompat.getColor(context, R.color.disabled_color)
    }
}

fun View?.enableView(textInputLayout: TextInputLayout? = null) {
    this?.isEnabled = true

    textInputLayout?.apply {
        isEnabled = true
        boxBackgroundColor = ContextCompat.getColor(context,R.color.transparent)
    }
}

fun View?.disableAllChildViews() {
    this?.isEnabled = false
    if (this is ViewGroup) {
        for (i in 0 until childCount) {
            getChildAt(i).disableView()
        }
    }
}

fun View?.disableAllViews() {

    tryCatch {

        when (this) {

            is ViewGroup -> {
                this.isEnabled = false
                forEach { child ->
                    if (child is TextInputLayout)
                        child.disableView(child)
                    else
                        child.disableAllViews()
                }
            }

            is RadioButton, is CheckBox -> disableView()

            is TextView -> enable()

            else -> disableView()

        }
    }
}

fun View.isViewGroup(): Boolean {
    return this is ViewGroup
}

fun View.setOnClickListeners(onClickListeners: ((View) -> Unit)) {

    var lastClickTime: Long = 0

    setOnClickListener {

        if (SystemClock.elapsedRealtime() - lastClickTime > 2000) {

            lastClickTime = SystemClock.elapsedRealtime()

            onClickListeners.invoke(it)
        }
    }
}

fun RadioButton.check() {
    isChecked = true
}

fun RadioButton.visibleAndCheck() {
    visibility = View.VISIBLE
    isChecked = true
}

fun RadioButton.unCheck() {
    isChecked = false
}

fun CheckBox.check() {
    isChecked = true
}

fun CheckBox.unCheck() {
    isChecked = false
}
