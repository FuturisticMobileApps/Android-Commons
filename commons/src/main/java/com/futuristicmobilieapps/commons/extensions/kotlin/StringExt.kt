package com.futuristicmobilieapps.commons.extensions.kotlin

import java.text.NumberFormat
import java.util.Locale

fun CharSequence?.validateString(): String {
    return this?.toString()?.trim() ?: ""
}
fun String?.validateLength(): Int {
    return validateString().length
}

fun String?.validateString(): String {
    return this?.trim() ?: ""
}

fun CharSequence?.isValidString(): Boolean {
    val textValue = this?.toString()?.trim() ?: return false
    return textValue.isNotEmpty() && !textValue.equals("null", ignoreCase = true)
}

fun String.convertToDollarFormat(): String =
    NumberFormat.getCurrencyInstance(Locale.US).format(validateString().toDoubleOrNull().validateDouble())

fun String?.getAmountValueFromDollarFormat(): Double {
    if (this.isNullOrEmpty() || !isValidString()) return 0.00

    return try {
        NumberFormat.getCurrencyInstance(Locale.US).parse(this)?.toDouble() ?: 0.00
    } catch (e: Exception) {
        this?.replace(Regex("[$,]"), "")?.trim()?.toDoubleOrNull() ?: 0.00
    }
}

