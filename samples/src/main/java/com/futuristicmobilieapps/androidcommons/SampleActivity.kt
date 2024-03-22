package com.futuristicmobilieapps.androidcommons

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.android.view.enableView
import com.google.android.material.textfield.TextInputLayout

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_activity)
//        val name = getStringResources(0)
//        Log.i("Name", "onCreate: name is $name")
    }
}

fun TextView?.getTextFromTextView(): String =
    if (this?.text?.toString().isValidString()) this?.text.toString().validateString() else ""

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


fun View.disableAllViews() {
    try {

        when (this) {

            is ViewGroup -> {
                forEach { child ->
                    if (child is TextInputLayout)
                        child.disableView(child)
                    else
                        child.disableAllViews()
                }
            }

            is RadioButton, is CheckBox -> disableView()

            is TextView -> enableView()

            else -> disableView()

        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun View.disableView(textInputLayout: TextInputLayout? = null) {

    isEnabled = false

    textInputLayout?.apply {

        isEnabled = false

    }
}

/*
fun View.enableView(textInputLayout: TextInputLayout? = null) {

    isEnabled = true

    textInputLayout?.apply {

        isEnabled = true

    }

}
*/

