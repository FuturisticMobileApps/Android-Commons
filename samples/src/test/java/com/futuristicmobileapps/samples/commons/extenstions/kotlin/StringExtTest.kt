package com.futuristicmobileapps.samples.commons.extenstions.kotlin

import com.futuristicmobilieapps.commons.extensions.kotlin.validateString
import com.futuristicmobilieapps.commons.extensions.kotlin.convertToDollarFormat
import com.futuristicmobilieapps.commons.extensions.kotlin.getAmountValueFromDollarFormat
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToDouble
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToFloat
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToInt
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToLong
import com.futuristicmobilieapps.commons.extensions.kotlin.validateLength
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StringExtTest {

    @Test
    fun `test validateString with non-null non-empty input`() {

        assertEquals("Hello", "  Hello  ".validateString())

        assertEquals("", "".validateString())

        assertEquals("", null.validateString())

        assertEquals("", "  ".validateString())
    }

    @Test
    fun `test validateLength with non-null non-empty input`() {

        assertEquals(5, "Hello".validateLength())

        assertEquals(0, "".validateLength())

        assertEquals(0, null.validateLength())

        assertEquals(0, "  ".validateLength())

        assertEquals(13, ("Hello, World!" as CharSequence).validateLength())
    }

    @Test
    fun `test isValidString with valid non-null non-empty input`() {

        //  Positive scenarios
        assertTrue("Hello".isValidString())

        assertTrue(("Hello World" as CharSequence).isValidString())

        assertTrue("Hello World".isValidString { it.isValidString() })

        assertTrue(("Hello World" as CharSequence).isValidString { it.isValidString() })

        //  Negative scenarios
        assertFalse("".isValidString())

        assertFalse(null.isValidString())

        assertFalse("   ".isValidString())

        assertFalse("null".isValidString())

        assertFalse("NuLL".isValidString())

    }

    @Test
    fun `test convertToDollarFormat with valid input`() {

        assertEquals("$1,234.56", "1234.56".convertToDollarFormat())

        assertEquals("$100.00", "100.00".convertToDollarFormat())

        assertEquals("$0.00", "abc".convertToDollarFormat())

        assertEquals("$0.00", "".convertToDollarFormat())

        assertEquals("$0.00", "   ".convertToDollarFormat())
    }

    @Test
    fun `test getAmountValueFromDollarFormat with valid input`() {

        assertEquals(1234.56, "$1,234.56".getAmountValueFromDollarFormat(), 0.01)

        assertEquals(100.0, "$100.00".getAmountValueFromDollarFormat(), 0.01)

        assertEquals(0.0, null.getAmountValueFromDollarFormat(), 0.01)

        assertEquals(0.0, "".getAmountValueFromDollarFormat(), 0.01)

        assertEquals(0.0, "   ".getAmountValueFromDollarFormat(), 0.01)
    }

    @Test
    fun `test stringToDouble with valid double string`() {

        assertEquals(3.14, "3.14".stringToDouble(), 0.0)

        assertEquals(0.0, "abc".stringToDouble(), 0.0)

        assertEquals(0.0, null.stringToDouble(), 0.0)
    }

    @Test
    fun `test stringToFloat with valid float string`() {

        assertEquals(3.14f, "3.14".stringToFloat())

        assertEquals(0f, "abc".stringToFloat())

        assertEquals(0f, null.stringToFloat())
    }

    @Test
    fun `test stringToLong with valid long string`() {

        assertEquals(42, "42".stringToLong())

        assertEquals(0, "abc".stringToLong())

        assertEquals(0, null.stringToLong())

        assertEquals(0, "".stringToLong())
    }

    @Test
    fun `test stringToInt with valid integer string`() {

        assertEquals(42, "42".stringToInt())

        assertEquals(0, "abc".stringToInt())

        assertEquals(0, null.stringToInt())

        assertEquals(0, "".stringToInt())
    }
}