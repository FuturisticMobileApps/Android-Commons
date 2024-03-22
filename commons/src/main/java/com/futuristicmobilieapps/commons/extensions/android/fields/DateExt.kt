package com.futuristicmobilieapps.commons.extensions.android.fields

import com.futuristicmobilieapps.commons.extensions.kotlin.validateString
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

const val oneDayInMs = 86400000

val e_dd_mmm_yyy_hh_mm_ss_z = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH)

val mm_dd_yyy__hh_mm_a_z = SimpleDateFormat("MM/dd/yyyy hh:mm a z", Locale.ENGLISH)

val MM_dd_yyyy = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)

val dd_MM_yyyy__HH_mm_ss = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH)


val EEEE_MMM_dd_yyyy__hh_mm_a = SimpleDateFormat("EEEE, MMM dd, yyyy hh:mm a", Locale.ENGLISH)


val iso8601Format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH)


val EEE_MMMM_dd_yyyy = SimpleDateFormat("EEE, MMMM dd, yyyy", Locale.ENGLISH)


val dd_MM_yy = SimpleDateFormat("dd/MM/yy", Locale.ENGLISH)


fun SimpleDateFormat.getDateFromMillis(timeInMillis: Long) = format(timeInMillis).validateString()

fun getCurrentYear(): Int = Calendar.getInstance().get(Calendar.YEAR)

fun getCurrentMonth(): Int = Calendar.getInstance().get(Calendar.MONTH)

fun SimpleDateFormat.getCurrentDate(): String = format(Date())

fun SimpleDateFormat.getCurrentTimeInMS(additionalTime: Long = 0): Date? {

    val currentTime = System.currentTimeMillis() + additionalTime

    return parse(format(currentTime))
}
