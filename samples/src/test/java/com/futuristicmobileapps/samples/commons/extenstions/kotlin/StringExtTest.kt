package com.futuristicmobileapps.samples.commons.extenstions.kotlin

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
        // Given
        val input: CharSequence = "  Hello  "

        // When
        val result = input.validateString()

        // Then
        assertEquals("Hello", result)
    }

    @Test
    fun `test validateString with non-null empty input`() {
        // Given
        val input: CharSequence = ""

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test validateString with null input`() {
        // Given
        val input: CharSequence? = null

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test validateString with input containing only whitespace`() {
        // Given
        val input: CharSequence = "   "

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test validateLength with non-null non-empty input`() {
        // Given
        val input = "Hello"

        // When
        val result = input.validateLength()

        // Then
        assertEquals(5, result)
    }

    @Test
    fun `test validateLength with non-null empty input`() {
        // Given
        val input = ""

        // When
        val result = input.validateLength()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `test validateLength with null input`() {
        // Given
        val input: String? = null

        // When
        val result = input.validateLength()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `test validateLength with input containing only whitespace`() {
        // Given
        val input = "   "

        // When
        val result = input.validateLength()

        // Then
        assertEquals(0, result)
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
        // Given
        val input = "1234.56"

        // When
        val result = input.convertToDollarFormat()

        // Then
        assertEquals("$1,234.56", result)
    }

    @Test
    fun `test convertToDollarFormat with valid input and trailing zeros`() {
        // Given
        val input = "100.00"

        // When
        val result = input.convertToDollarFormat()

        // Then
        assertEquals("$100.00", result)
    }

    @Test
    fun `test convertToDollarFormat with invalid input`() {
        // Given
        val input = "abc"

        // When
        val result = input.convertToDollarFormat()

        // Then
        assertEquals("$0.00", result)
    }

    @Test
    fun `test convertToDollarFormat with empty input`() {
        // Given
        val input = ""

        // When
        val result = input.convertToDollarFormat()

        // Then
        assertEquals("$0.00", result)
    }

    @Test
    fun `test convertToDollarFormat with input containing only whitespace`() {
        // Given
        val input = "   "

        // When
        val result = input.convertToDollarFormat()

        // Then
        assertEquals("$0.00", result)
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
        // Given
        val input = "3.14"

        // When
        val result = input.stringToFloat()

        // Then
        assertEquals(3.14f, result)
    }

    @Test
    fun `test stringToFloat with invalid float string`() {
        // Given
        val input = "abc"

        // When
        val result = input.stringToFloat()

        // Then
        assertEquals(0f, result)
    }

    @Test
    fun `test stringToFloat with null input`() {
        // Given
        val input: String? = null

        // When
        val result = input.stringToFloat()

        // Then
        assertEquals(0f, result)
    }

    @Test
    fun `test stringToFloat with empty string`() {
        // Given
        val input = ""

        // When
        val result = input.stringToFloat()

        // Then
        assertEquals(0f, result)
    }

    @Test
    fun `test stringToInt with valid integer string`() {
        // Given
        val input = "42"

        // When
        val result = input.stringToInt()

        // Then
        assertEquals(42, result)
    }

    @Test
    fun `test stringToInt with invalid integer string`() {
        // Given
        val input = "abc"

        // When
        val result = input.stringToInt()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `test stringToInt with null input`() {
        // Given
        val input: String? = null

        // When
        val result = input.stringToInt()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `test stringToInt with empty string`() {
        // Given
        val input = ""

        // When
        val result = input.stringToInt()

        // Then
        assertEquals(0, result)
    }


}