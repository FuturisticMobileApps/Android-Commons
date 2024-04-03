package com.futuristicmobilieapps.commons.extensions.android.view

import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString
import com.futuristicmobilieapps.commons.extensions.kotlin.validateString


var TextView?.textValue: String?
    get() = this?.text.toString().validateString()
    set(value) {
        this?.text = value.validateString()
    }

fun TextView?.clearText() {
    textValue = ""
}

fun TextView?.isValidString(): Boolean = textValue.isValidString()

fun TextView?.visibleAndSetText(input: String) {
    visible()
    textValue = input
}

fun TextView?.setLink() {
    this?.movementMethod = LinkMovementMethod.getInstance()
}








