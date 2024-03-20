package com.futuristicmobilieapps.commons.extensions.android.view

import android.widget.TextView
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString

fun TextView?.clearText() {
    if (this?.text.isNullOrEmpty()) return
    else this!!.text = ""
}

fun TextView?.isValidText(): Boolean = this?.text.toString().isValidString()

