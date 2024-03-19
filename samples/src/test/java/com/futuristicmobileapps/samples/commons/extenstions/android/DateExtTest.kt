package com.futuristicmobileapps.samples.commons.extenstions.android

import com.futuristicmobilieapps.commons.extensions.android.fields.getCurrentDate
import com.futuristicmobilieapps.commons.extensions.android.fields.getCurrentMonth
import com.futuristicmobilieapps.commons.extensions.android.fields.getCurrentTimeInMS
import com.futuristicmobilieapps.commons.extensions.android.fields.getCurrentYear
import com.futuristicmobilieapps.commons.extensions.android.fields.getDateFromMillis
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class DateExtTest{

    @Test
    fun `test getDateFromMillis with valid input`() {
        // Given
        val timeInMillis = 1616264400000 // March 20, 2021 12:00:00 AM UTC
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        // When
        val result = dateFormat.getDateFromMillis(timeInMillis)

        // Then
        assertEquals("2021-03-20", result)
    }

    @Test
    fun `test getCurrentYear`() {
        // Given
        val expectedYear = Calendar.getInstance().get(Calendar.YEAR)

        // When
        val result = getCurrentYear()

        // Then
        assertEquals(expectedYear, result)
    }

    @Test
    fun `test getCurrentMonth`() {
        // Given
        val expectedMonth = Calendar.getInstance().get(Calendar.MONTH) + 1

        // When
        val result = getCurrentMonth()

        // Then
        assertEquals(expectedMonth, result)
    }

    @Test
    fun `test getCurrentDate`() {
        // Given
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val expectedDate = dateFormat.format(Date())

        // When
        val result = dateFormat.getCurrentDate()

        // Then
        assertEquals(expectedDate, result)
    }

    @Test
    fun `test getCurrentTimeInMS with no additional time`() {
        // Given
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val expectedDate = dateFormat.parse(dateFormat.format(System.currentTimeMillis()))

        // When
        val result = dateFormat.getCurrentTimeInMS()

        // Then
        assertEquals(expectedDate, result)
    }

    @Test
    fun `test getCurrentTimeInMS with additional time`() {
        // Given
        val additionalTime: Long = 86400000 // Adding 24 hours
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val expectedDate = dateFormat.parse(dateFormat.format(System.currentTimeMillis() + additionalTime))

        // When
        val result = dateFormat.getCurrentTimeInMS(additionalTime)

        // Then
        assertEquals(expectedDate, result)
    }
}