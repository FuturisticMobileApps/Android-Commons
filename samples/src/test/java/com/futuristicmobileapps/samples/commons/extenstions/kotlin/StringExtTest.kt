package com.futuristicmobileapps.samples.commons.extenstions.kotlin

import com.futuristicmobilieapps.androidcommons.validateString
import com.futuristicmobilieapps.commons.extensions.kotlin.convertToDollarFormat
import com.futuristicmobilieapps.commons.extensions.kotlin.getAmountValueFromDollarFormat
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToFloat
import com.futuristicmobilieapps.commons.extensions.kotlin.stringToInt
import com.futuristicmobilieapps.commons.extensions.kotlin.validateLength
import com.futuristicmobilieapps.commons.extensions.kotlin.validateString
import org.junit.Test
import org.junit.Assert.*
class StringExtTest{

    @Test
    fun `test validateString with non-null non-empty input`() {

        assertEquals("Hello", "  Hello  ".validateString())

        assertEquals("","".validateString())

        assertEquals("", null.validateString())

        assertEquals("", "  ".validateString())
    }

    @Test
    fun `test validateLength with non-null non-empty input`() {

        assertEquals(5, "Hello".validateLength())

        assertEquals(0, "".validateLength())

        assertEquals(0, null.validateLength())

        assertEquals(0, "  ".validateLength())
    }

    @Test
    fun `test isValidString with valid non-null non-empty input`() {
        // Given
        val input = "Hello"

        // When
        val result = input.isValidString()

        // Then
        assertTrue(result)
    }

    @Test
    fun `test isValidString with valid non-null empty input`() {
        // Given
        val input: CharSequence = ""

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with valid null input`() {
        // Given
        val input: CharSequence? = null

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with valid input containing only whitespace`() {
        // Given
        val input: CharSequence = "   "

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with invalid input null`() {
        // Given
        val input: CharSequence = "null"

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with invalid input NuLL`() {
        // Given
        val input: CharSequence = "NuLL"

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with valid non-null non-empty inputString`() {
        // Given
        val input: CharSequence = "Hello World"

        // When
        val result = input.isValidString()

        // Then
        assertTrue(result)
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
        // Given
        val input = "$1,234.56"

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(1234.56, result, 0.01)
    }

    @Test
    fun `test getAmountValueFromDollarFormat with valid input and trailing zeros`() {
        // Given
        val input = "$100.00"

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(100.0, result, 0.01)
    }

    @Test
    fun `test getAmountValueFromDollarFormat with invalid input`() {
        // Given
        val input = "abc"

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun `test getAmountValueFromDollarFormat with null input`() {
        // Given
        val input: String? = null

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun `test getAmountValueFromDollarFormat with empty input`() {
        // Given
        val input = ""

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun `test getAmountValueFromDollarFormat with input containing only whitespace`() {
        // Given
        val input = "   "

        // When
        val result = input.getAmountValueFromDollarFormat()

        // Then
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun `test stringToFloat with valid float string`() {

        assertEquals(3.14f, "3.14".stringToFloat())

        assertEquals(0f, "abc".stringToFloat())

        assertEquals(0f, null.stringToFloat())
    }

    @Test
    fun `test stringToInt with valid integer string`() {

        assertEquals(42, "42".stringToInt())

        assertEquals(0, "abc".stringToInt())

        assertEquals(0, null.stringToInt())

        assertEquals(0, "".stringToInt())
    }
}