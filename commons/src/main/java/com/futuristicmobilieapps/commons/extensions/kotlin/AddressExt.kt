package com.futuristicmobilieapps.commons.extensions.kotlin

import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.futuristicmobilieapps.commons.extensions.android.view.onTextChangedTextWatcher
import com.google.android.material.textfield.TextInputEditText

fun TextView?.getTextFromTextView(): String =
    if (this?.text?.toString().isValidString()) this?.text.toString().validateString() else ""


fun EditText.convertToUsPhoneNumber() {

    onTextChangedTextWatcher { textWatcher ->

        val phone = getTextFromTextView().replace("\\W".toRegex(), "")

        if (phone.isEmpty() || phone.length > 14) return@onTextChangedTextWatcher

        val formattedPhone = when (phone.length) {

            3 -> String.format("(%s)", phone.substring(0, 3))

            6 -> String.format("(%s) %s", phone.substring(0, 3), phone.substring(3, 6))

            10 -> String.format(
                "(%s) %s-%s",
                phone.substring(0, 3),
                phone.substring(3, 6),
                phone.substring(6, 10)
            )

            else -> return@onTextChangedTextWatcher
        }

        removeTextChangedListener(textWatcher)

        setText(formattedPhone)

        setSelection(formattedPhone.length)

        addTextChangedListener(textWatcher)

    }
}

fun EditText.convertToEIN() {

  onTextChangedTextWatcher { textWatcher->

            val input = text.toString().replace(Regex("[()-//s]"), "")

            if (input.isEmpty()) return@onTextChangedTextWatcher

            val regex = "^\\(?([0-9]{2})\\)?[-.]?([0-9]{7})$".toRegex()

            val formattedNumber = input.replace(regex) { result ->

                "${result.groupValues[1]}-${result.groupValues[2]}"
            }

            removeTextChangedListener(textWatcher)

            setText(formattedNumber)

            setSelection(formattedNumber.length)

            addTextChangedListener(textWatcher)
       }
}

fun EditText.convertZipCode(textWatcher: TextWatcher) {

    (this as? TextInputEditText)?.let { textInputEditText ->
        textInputEditText.onTextChangedTextWatcher {

            val input = textInputEditText.text.toString().replace(Regex("[()-//s]"), "")

            if (input.length > 10) return@onTextChangedTextWatcher

            val regex = "^\\(?([0-9]{5})\\)?[-.\\s]?([0-9]{4})$".toRegex()

            val formattedNumber = input.replace(regex) { result ->
                "${result.groupValues[1]}-${result.groupValues[2]}"
            }

            textInputEditText.apply {

                removeTextChangedListener(textWatcher)

                setText(formattedNumber)

                setSelection(formattedNumber.length)

                addTextChangedListener(textWatcher)
            }
        }
    }
}








