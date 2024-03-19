package com.futuristicmobileapps.samples.commons.extenstions.kotlin

import com.futuristicmobilieapps.commons.extensions.kotlin.isValidInt
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidLong
import com.futuristicmobilieapps.commons.extensions.kotlin.validateBoolean
import com.futuristicmobilieapps.commons.extensions.kotlin.validateDouble
import com.futuristicmobilieapps.commons.extensions.kotlin.validateFloat
import com.futuristicmobilieapps.commons.extensions.kotlin.validateInt
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class DataTypeExtTest{
    @Test
    fun `test validateInt with non-null input`() {
        // Given
        val input= 10

        // When
        val result = input.validateInt()

        // Then
        assertEquals(10, result)
    }

    @Test
    fun `test validateInt with null input`() {
        // Given
        val input: Int? = null

        // When
        val result = input.validateInt()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `test validateFloat with non-null input`() {
        // Given
        val input = 10.5f

        // When
        val result = input.validateFloat()

        // Then
        assertEquals(10.5f, result, 0.0f)
    }

    @Test
    fun `test validateFloat with null input`() {
        // Given
        val input: Float? = null

        // When
        val result = input.validateFloat()

        // Then
        assertEquals(0.0f, result, 0.0f)
    }

    @Test
    fun `test validateDouble with non-null input`() {
        // Given
        val input = 10.5

        // When
        val result = input.validateDouble()

        // Then
        assertEquals(10.5, result, 0.0)
    }

    @Test
    fun `test validateDouble with null input`() {
        // Given
        val input: Double? = null

        // When
        val result = input.validateDouble()

        // Then
        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun `test isValidLong with non-null input`() {
        // Given
        val input = 10L

        // When
        val result = isValidLong(input)

        // Then
        assertTrue(result)
    }

    @Test
    fun `test isValidLong with null input`() {
        // Given
        val input: Long? = null

        // When
        val result = isValidLong(input)

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidInt with positive input`() {
        // Given
        val input = 10

        // When
        val result = input.isValidInt()

        // Then
        assertTrue(result)
    }

    @Test
    fun `test isValidInt with zero input`() {
        // Given
        val input = 0

        // When
        val result = input.isValidInt()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidInt with negative input`() {
        // Given
        val input: Int = -5

        // When
        val result = input.isValidInt()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test isValidInt with null input`() {
        // Given
        val input: Int? = null

        // When
        val result = input.isValidInt()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test validateBoolean with true input`() {
        // Given
        val input = true

        // When
        val result = input.validateBoolean()

        // Then
        assertTrue(result)
    }

    @Test
    fun `test validateBoolean with false input`() {
        // Given
        val input = false

        // When
        val result = input.validateBoolean()

        // Then
        assertFalse(result)
    }

    @Test
    fun `test validateBoolean with null input`() {
        // Given
        val input: Boolean? = null

        // When
        val result = input.validateBoolean()

        // Then
        assertFalse(result)
    }
}