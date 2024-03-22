package com.futuristicmobilieapps.commons.extensions.android.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

inline fun EditText.onTextChangedTextWatcher(
    crossinline function: (tw:TextWatcher) -> Unit,
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

