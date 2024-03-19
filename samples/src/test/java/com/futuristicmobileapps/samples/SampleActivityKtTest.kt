package com.futuristicmobileapps.samples

import android.widget.TextView
import com.futuristicmobilieapps.androidcommons.getTextFromTextView
import com.futuristicmobilieapps.androidcommons.validateString
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`


class MockitoSampleTest {

    @Test
    fun testValidString() {
        val textView = mock(TextView::class.java)
        `when`(textView.text).thenReturn(null)
        val result = textView.getTextFromTextView()
        assertEquals("", result)
    }

    @Test
    fun testEmptyString() {
        val textView = mock(TextView::class.java)
        `when`(textView.text).thenReturn(null)
        val result = textView.getTextFromTextView()
        assertEquals("", result)
    }

    @Test
    fun testInvalidString() {
        val textView = mock(TextView::class.java)
        `when`(textView.text).thenReturn("  ")
        val result = textView.getTextFromTextView()
        assertEquals("", result)
    }
}


class SampleActivityKtTest {

    @Test
    fun `null string`() {
        val nullString: String? = null
        assertEquals("", nullString.validateString())
    }

    @Test
    fun `empty string`() {
        val emptyString = ""
        assertEquals("", emptyString.validateString())
    }

    @Test
    fun `non-empty string`() {
        val nonEmptyString = "Hello"
        assertEquals("Hello", nonEmptyString.validateString())
    }

    @Test
    fun `string with leading whitespace`() {
        val stringWithLeadingWhitespace = "   Hello"
        assertEquals("Hello", stringWithLeadingWhitespace.validateString())
    }

    @Test
    fun `string with trailing whitespace`() {
        val stringWithTrailingWhitespace = "Hello   "
        assertEquals("Hello", stringWithTrailingWhitespace.validateString())
    }

    @Test
    fun `string with leading and trailing whitespace`() {
        val stringWithLeadingAndTrailingWhitespace = "   Hello   "
        assertEquals("Hello", stringWithLeadingAndTrailingWhitespace.validateString())
    }

}