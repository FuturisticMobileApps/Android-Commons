package com.futuristicmobileapps.samples.commons.extensions.android.util

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.futuristicmobilieapps.androidcommons.R
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import org.junit.Assert.*
import org.junit.Test


class ContextExtKtTest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun getStringResourcesTest() {

        // Test with valid Id
        assertEquals("Android-Commons", context.getStringResources(R.string.app_name))

        // Test with in-valid Id
        assertEquals("", context.getStringResources(0))

        // Test with null Id
        assertEquals("", context.getStringResources(null))

    }

}
