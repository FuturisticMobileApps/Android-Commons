package com.futuristicmobilieapps.commons.extensions.kotlin

import java.text.NumberFormat
import java.util.Locale

fun CharSequence?.validateString() = this?.toString()?.trim() ?: ""

fun String?.validateLength() = validateString().length

fun CharSequence?.isValidString(): Boolean {

    val textValue = this?.toString()?.trim() ?: return false

    return textValue.isNotEmpty() && !textValue.equals("null", ignoreCase = true)
}

fun String.convertToDollarFormat(): String =

    NumberFormat.getCurrencyInstance(Locale.US).format(validateString()

        .toDoubleOrNull().validateDouble())


fun String?.getAmountValueFromDollarFormat(): Double {

    if (!isValidString() || isNullOrEmpty()) return 0.00

    return String.let {

        NumberFormat.getCurrencyInstance(Locale.US).parse(this)?.toDouble() ?: 0.00
    }
}

fun String?.stringToFloat(): Float = this?.toFloatOrNull() ?: 0F

fun String?.stringToInt():Int = this?.toIntOrNull() ?: 0



