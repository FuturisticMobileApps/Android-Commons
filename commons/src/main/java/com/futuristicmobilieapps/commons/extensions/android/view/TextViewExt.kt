package com.futuristicmobilieapps.commons.extensions.android.view

import android.annotation.SuppressLint
import android.text.method.LinkMovementMethod
import android.view.MotionEvent
import android.widget.TextView
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString
import com.futuristicmobilieapps.commons.extensions.kotlin.validateString


var TextView?.textForTextView: String?
    get() = this?.text.toString().validateString()
    set(value) {
        this?.text = value.validateString()
    }

fun TextView?.setTextForTextView(input: String? = "") {
    this?.text = input.validateString()

    this.textForTextView
}

fun TextView?.getTextFromTextView(): String =
    if (this?.text?.toString().isValidString()) this?.text.toString().validateString() else ""

fun TextView?.clearText() {
    textForTextView = ""
}

fun TextView?.isValidText(): Boolean = textForTextView.isValidString()

fun TextView?.visibleAndSetText(input: String?) {
    visible()
    textForTextView = input
}

fun TextView?.setLink() {
    this?.movementMethod = LinkMovementMethod.getInstance()
}

@SuppressLint("ClickableViewAccessibility")
fun TextView?.setclicklistener(listener: () -> Unit) {
    this?.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val handler = android.os.Handler()
                handler.postDelayed({
                    // Remove the callbacks when the touch duration exceeds 2 seconds
                    handler.removeCallbacksAndMessages(null)
                }, 2000)
            }

            MotionEvent.ACTION_UP -> {
                // Call onClick only if the touch duration was less than 2 seconds
                listener()
            }
        }
        true // Consume the event
    }

}











