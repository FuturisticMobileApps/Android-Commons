package com.futuristicmobileapps.samples.commons.extenstions.kotlin

import com.futuristicmobilieapps.commons.extensions.kotlin.getCurrentDate
import com.futuristicmobilieapps.commons.extensions.kotlin.getCurrentMonth
import com.futuristicmobilieapps.commons.extensions.kotlin.getCurrentTimeInMS
import com.futuristicmobilieapps.commons.extensions.kotlin.getCurrentYear
import com.futuristicmobilieapps.commons.extensions.kotlin.getDateFromMillis
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class DateExtTest{

    @Test
    fun `test getDateFromMillis with valid input`() {

        val timeInMillis = 1616264400000 // March 20, 2021 12:00:00 AM UTC
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")


        val result = dateFormat.getDateFromMillis(timeInMillis)


        assertEquals("2021-03-20", result)
    }

    @Test
    fun `test getCurrentYear`() {

        assertEquals(Calendar.getInstance().get(Calendar.YEAR), getCurrentYear())
    }

    @Test
    fun `test getCurrentMonth`() {

        assertEquals(Calendar.getInstance().get(Calendar.MONTH), getCurrentMonth())
    }

    @Test
    fun `test getCurrentDate`() {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        assertEquals(dateFormat.format(Date()), dateFormat.getCurrentDate())
    }

    @Test
    fun `test getCurrentTimeInMS with no additional time`() {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        assertEquals(dateFormat.parse(dateFormat.format(System.currentTimeMillis())),
            dateFormat.getCurrentTimeInMS())
    }

    @Test
    fun `test getCurrentTimeInMS with additional time`() {

        val additionalTime: Long = 86400000 // Adding 24 hours
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        assertEquals(dateFormat.parse(dateFormat.format(System.currentTimeMillis() +
                additionalTime)), dateFormat.getCurrentTimeInMS(additionalTime))
    }
}