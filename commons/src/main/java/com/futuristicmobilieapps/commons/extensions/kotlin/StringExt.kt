package com.futuristicmobilieapps.commons.extensions.kotlin

import com.futuristicmobilieapps.commons.extensions.android.util.tryCatch
import java.text.NumberFormat
import java.util.Locale

fun CharSequence?.validateString() = this?.toString()?.trim() ?: ""

fun String?.validateLength() = validateString().length

fun CharSequence?.isValidString(): Boolean {

    val textValue = this?.toString()?.trim() ?: return false

    return textValue.isNotEmpty() && !textValue.equals("null", ignoreCase = true)
}

fun String?.convertToDollarFormat(): String = NumberFormat.getCurrencyInstance(Locale.US).format(
    validateString().stringToDouble()
)

fun String?.getAmountFromDollarFormat(): Double = tryCatch(0.0) {
    validateString().run {
        NumberFormat.getCurrencyInstance(Locale.US).parse(this)?.toDouble() ?: 0.0
    }
}

fun String?.stringToInt(): Int = this?.toIntOrNull() ?: 0

fun String?.stringToFloat(): Float = this?.toFloatOrNull() ?: 0F

fun String?.stringToDouble(): Double = this?.toDoubleOrNull() ?: 0.0



