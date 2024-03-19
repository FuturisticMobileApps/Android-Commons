package com.futuristicmobilieapps.commons.extensions.android.fields

import com.futuristicmobilieapps.commons.extensions.kotlin.validateString
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun SimpleDateFormat.getDateFromMillis(timeInMillis: Long) = format(timeInMillis).validateString()

fun getCurrentYear(): Int = Calendar.getInstance().get(Calendar.YEAR)

fun getCurrentMonth(): Int = Calendar.getInstance().get(Calendar.MONTH)

fun SimpleDateFormat.getCurrentDate(): String = format(Date())

fun SimpleDateFormat.getCurrentTimeInMS(additionalTime: Long = 0): Date? {

    val currentTime = System.currentTimeMillis() + additionalTime

    return parse(format(currentTime))
}
