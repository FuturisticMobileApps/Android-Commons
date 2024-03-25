package com.futuristicmobilieapps.commons.extensions.android.fields

import android.widget.EditText
import android.widget.TextView
import com.futuristicmobilieapps.commons.extensions.android.view.onTextChangedTextWatcher
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString
import com.futuristicmobilieapps.commons.extensions.kotlin.validateString

fun TextView?.getTextFromTextView(): String =
    if (this?.text?.toString().isValidString()) this?.text.toString().validateString() else ""

fun EditText.convertToUsPhoneNumber() {

    onTextChangedTextWatcher { textWatcher ->

        val phone = getTextFromTextView().replace("\\W".toRegex(), "")

        val formattedPhone = when (phone.length) {

            in 4..5 -> String.format("(%s) %s", phone.substring(0, 3), phone.substring(3))

            in 7..9 -> String.format(
                "(%s) %s-%s",
                phone.substring(0, 3),
                phone.substring(3, 6),
                phone.substring(6)
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

    onTextChangedTextWatcher { textWatcher ->

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

fun EditText.convertZipCode() {

    onTextChangedTextWatcher { textWatcher ->

        val input = text.toString().replace(Regex("[()-//s]"), "")

        if (input.length > 10) return@onTextChangedTextWatcher

        val regex = "^\\(?([0-9]{5})\\)?[-.\\s]?([0-9]{4})$".toRegex()

        val formattedNumber = input.replace(regex) { result ->
            "${result.groupValues[1]}-${result.groupValues[2]}"
        }

        removeTextChangedListener(textWatcher)

        setText(formattedNumber)

        setSelection(formattedNumber.length)

        addTextChangedListener(textWatcher)

    }
}

fun EditText.ssnMasking() {

    onTextChangedTextWatcher { textWatcher ->

        val input = text.toString().replace(Regex("[()-//s]"), "")

        val formattedNumber = input.replace(Regex("(\\d{3})(\\d{2})(\\d{4})"), "$1-$2-$3")

        removeTextChangedListener(textWatcher)

        setText(formattedNumber)

        setSelection(formattedNumber.length)

        addTextChangedListener(textWatcher)
    }
}



