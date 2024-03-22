package com.futuristicmobilieapps.commons.extensions.kotlin

import com.futuristicmobilieapps.commons.extensions.android.util.tryCatch
import java.text.NumberFormat
import java.util.Locale

fun String?.validateString(): String = this?.trim() ?: ""

fun String?.validateLength(): Int = validateString().length

fun CharSequence?.validateString(): String = this?.toString().validateString()

fun CharSequence?.validateLength(): Int = validateString().validateLength()

fun String?.isValidString(): Boolean =
    !isNullOrBlank() && !validateString().equals("null", true) && validateString() != ""

fun CharSequence?.isValidString(): Boolean = validateString().isValidString()

inline fun String?.isValidString(string: (String) -> Unit): Boolean =
    isValidString().also { isValid -> if (isValid) string(validateString()) }

inline fun CharSequence?.isValidString(string: (String) -> Unit): Boolean =
    isValidString().also { isValid -> if (isValid) string(validateString()) }

fun String?.convertToDollarFormat(): String = NumberFormat.getCurrencyInstance(Locale.US).format(
    validateString().stringToDouble()
)

fun String?.getAmountFromDollarFormat(): Double = tryCatch(0.0) {
    validateString().run {
        NumberFormat.getCurrencyInstance(Locale.US).parse(this)?.toDouble() ?: 0.0
    }
}


fun String?.stringToDouble(): Double = this?.toDoubleOrNull() ?: 0.0

fun String?.stringToFloat(): Float = this?.toFloatOrNull() ?: 0F

fun String?.stringToLong(): Long = this?.toLongOrNull() ?: 0

fun String?.stringToInt(): Int = this?.toIntOrNull() ?: 0



