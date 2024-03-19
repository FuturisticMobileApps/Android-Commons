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

    return NumberFormat.getCurrencyInstance(Locale.US)
        .parse(this.validateString())?.toDouble() ?: this?.validateString()
        ?.replace(Regex("[$,]"), "")?.toDoubleOrNull() ?: 0.00
}


