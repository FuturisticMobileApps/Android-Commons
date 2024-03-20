package com.futuristicmobilieapps.commons.extensions.kotlin

import java.text.NumberFormat
import java.text.ParseException
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

    val cleanedString = this?.validateString() ?: return 0.0

    return try {

        NumberFormat.getCurrencyInstance(Locale.US).parse(cleanedString)?.toDouble() ?:

        cleanedString.replace(Regex("[$,]"), "").toDoubleOrNull() ?: 0.0

    } catch (e: ParseException) {

        0.0
    }
}

fun String?.stringToFloat(): Float = this?.toFloatOrNull() ?: 0F

fun String?.stringToInt():Int = this?.toIntOrNull() ?: 0



