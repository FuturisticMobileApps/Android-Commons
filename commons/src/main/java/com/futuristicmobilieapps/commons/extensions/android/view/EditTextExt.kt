package com.futuristicmobilieapps.commons.extensions.android.view

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

inline fun TextInputEditText.onTextChangedTextWatcher(
    crossinline function: (Unit) -> Unit,
) {
    val textWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            return
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            function(Unit)
        }

        override fun afterTextChanged(s: Editable?) {

            return
        }
    }

    addTextChangedListener(textWatcher)
}
