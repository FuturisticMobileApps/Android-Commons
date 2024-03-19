package com.futuristicmobilieapps.commons.extensions.kotlin

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
    fun `test validateLength with non-null non-empty input`() {
        // Given
        val input: String? = "Hello"

        // When
        val result = input.validateLength()

        // Then
        assertEquals(5, result)
    }

    @Test
    fun `test validateLength with non-null empty input`() {
        // Given
        val input: String? = ""

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
    fun `test validateString with non-null input`() {
        // Given
        val input: String? = "  Hello  "

        // When
        val result = input.validateString()

        // Then
        assertEquals("Hello", result)
    }

    @Test
    fun `test validateString with null inputString`() {
        // Given
        val input: String? = null

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test validateString with empty input`() {
        // Given
        val input: String? = ""

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test validateString with input containing only whitespace`() {
        // Given
        val input: String? = "   "

        // When
        val result = input.validateString()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test isValidString with non-null non-empty input`() {
        // Given
        val input: CharSequence? = "Hello"

        // When
        val result = input.isValidString()

        // Then
        assertTrue(result)
    }

    @Test
    fun `test isValidString with non-null empty input`() {
        // Given
        val input: CharSequence? = ""

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with null input`() {
        // Given
        val input: CharSequence? = null

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with input containing only whitespace`() {
        // Given
        val input: CharSequence? = "   "

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with input null`() {
        // Given
        val input: CharSequence? = "null"

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with input NuLL`() {
        // Given
        val input: CharSequence? = "NuLL"

        // When
        val result = input.isValidString()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidString with input Hello World`() {
        // Given
        val input: CharSequence? = "Hello World"

        // When
        val result = input.isValidString()

        // Then
        assertTrue(result)
    }
}


