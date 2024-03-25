package com.futuristicmobilieapps.commons.extensions.android.util

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