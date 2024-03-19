package com.futuristicmobilieapps.androidcommons

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_activity)
    }
}

fun TextView?.getTextFromTextView(): String =
    if (this?.text?.toString().isValidString()) this?.text.toString().validateString() else "null"

fun CharSequence?.isValidString(): Boolean {

    if (this.isNullOrEmpty()) return false

    val textValue = this.toString()

    return textValue.trim { it <= ' ' }.isNotEmpty() &&

            !textValue.trim { it <= ' ' }.equals("null", ignoreCase = true) &&

            !textValue.trim { it <= ' ' }.equals("", ignoreCase = true)

}

fun String?.validateString(): String {

    if (this.isNullOrEmpty()) return ""

    return this.trim()

}