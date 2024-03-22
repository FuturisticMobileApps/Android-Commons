package com.futuristicmobileapps.samples.commons.extenstions.android.util

import android.content.Context
import android.content.res.Resources
import android.widget.TextView
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class ContextExtTest {

    private val textView = mock(TextView::class.java)

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

        `when`(textView.text).thenReturn("hii")

        // Test with valid Id
        assertEquals("Hello", context.getStringResources(101))

        // Test with in-valid Id
        assertEquals("", context.getStringResources(0))

        // Test with null Id
        assertEquals("", context.getStringResources(null))

    }


}