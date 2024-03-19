package com.futuristicmobilieapps.commons.extensions.kotlin

fun Int?.validateInt(): Int = this ?: 0

fun Float?.validateFloat(): Float = this ?: 0f

fun Double?.validateDouble(): Double = this ?: 0.0

fun isValidLong(long: Long?): Boolean = long != null

fun Int?.isValidInt(): Boolean = validateInt() > 0

fun Boolean?.validateBoolean(): Boolean = this ?: false


