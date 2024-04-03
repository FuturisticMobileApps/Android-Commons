package com.futuristicmobilieapps.commons.extensions.android.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToFloat
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToInt

inline fun EditText.onTextChangedTextWatcher(
    crossinline function: (tw: TextWatcher) -> Unit,
) {
    val textWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            return
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            function(this)

        }

        override fun afterTextChanged(s: Editable?) {

            return
        }
    }

    addTextChangedListener(textWatcher)
}

fun EditText?.validLength(): Int = textValue?.length ?: 0

fun EditText.stringToFloat(): Float = textValue.stringToFloat()

fun EditText.stringToInt(): Int = textValue.stringToInt()





