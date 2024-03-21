package com.futuristicmobileapps.samples.commons.extenstions.android.util

import android.content.Context
import android.content.res.Resources
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class ContextExtTest {

    private val context: Context = mock(Context::class.java)
    private val resources: Resources = mock(Resources::class.java)

    @Before
    fun setUP() {
        `when`(context.resources).thenReturn(resources)
        `when`(context.resources.getString(0)).thenThrow(Resources.NotFoundException())
        `when`(context.resources.getString(101)).thenReturn("Hello")
    }

    @Test
    fun getStringResourcesTest() {

        // Test with valid Id
        assertEquals("Hello", context.getStringResources(101))

        // Test with in-valid Id
        assertEquals("", context.getStringResources(0))

        // Test with null Id
        assertEquals("", context.getStringResources(null))

    }


}