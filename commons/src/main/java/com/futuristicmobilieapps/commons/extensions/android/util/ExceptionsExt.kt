package com.futuristicmobilieapps.commons.extensions.android.util

import android.content.res.Resources
import java.text.ParseException

inline fun <T> tryCatch(noinline onCatch: (() -> Unit?)? = null, block: () -> T) {
    try {
        block()
    } catch (e: Exception) {
        onCatch?.invoke()
    }
}

inline fun <T> tryCatch(defaultValue: T, block: () -> T): T {
    return try {
        block()
    } catch (e: Exception) {
        defaultValue
    }
}

inline fun <T> tryCatchNotFoundException(defaultValue: T, block: () -> T): T =
    try {
        block()
    } catch (e: Resources.NotFoundException) {
        defaultValue
    }

inline fun <T> tryCatchParcException(defaultValue: T, block: () -> T): T =
    try {
        block()
    } catch (e: ParseException) {
        defaultValue
    }