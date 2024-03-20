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

        assertEquals(10, 10.validateInt())

        assertEquals(0, null.validateInt())
    }


    @Test
    fun `test validateFloat with non-null input`() {

        assertEquals(10.5f, 10.5f.validateFloat(), 0.0f)

        assertEquals(0.0f, null.validateFloat(), 0.0f)
    }

    @Test
    fun `test validateDouble with non-null input`() {

        assertEquals(10.5, 10.5.validateDouble(), 0.0)

        assertEquals(0.0, null.validateDouble(), 0.0)
    }


    @Test
    fun `test isValidLong with non-null input`() {

        assertTrue(isValidLong( 10L))

        assertFalse(isValidLong(null))
    }

    @Test
    fun `test isValidInt with positive input`() {

        val input: Int = -5

        assertTrue(10.isValidInt())

        assertFalse(0.isValidInt())

        assertFalse(input.isValidInt())

        assertFalse(null.isValidInt())
    }


    @Test
    fun `test validateBoolean with true input`() {

        assertTrue(true.validateBoolean())

        assertFalse(false.validateBoolean())

        assertFalse(null.validateBoolean())
    }

}