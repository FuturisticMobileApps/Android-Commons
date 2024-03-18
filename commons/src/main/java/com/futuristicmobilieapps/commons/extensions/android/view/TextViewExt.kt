package com.futuristicmobilieapps.commons.extensions.android.view

import android.widget.TextView

fun TextView?.clearText() {
    if (this?.text.isNullOrEmpty()) return
    else this!!.text = ""
}