package com.futuristicmobileapps.samples

import com.futuristicmobilieapps.androidcommons.validateString
import org.junit.Assert
import org.junit.Test


class SampleActivityKtTest {

    @Test
    fun `null string`() {
        val nullString: String? = null
        Assert.assertEquals("", nullString.validateString())
    }

    @Test
    fun `empty string`() {
        val emptyString = ""
        Assert.assertEquals("", emptyString.validateString())
    }

    @Test
    fun `non-empty string`() {
        val nonEmptyString = "Hello"
        Assert.assertEquals("Hello", nonEmptyString.validateString())
    }

    @Test
    fun `string with leading whitespace`() {
        val stringWithLeadingWhitespace = "   Hello"
        Assert.assertEquals("Hello", stringWithLeadingWhitespace.validateString())
    }

    @Test
    fun `string with trailing whitespace`() {
        val stringWithTrailingWhitespace = "Hello   "
        Assert.assertEquals("Hello", stringWithTrailingWhitespace.validateString())
    }

    @Test
    fun `string with leading and trailing whitespace`() {
        val stringWithLeadingAndTrailingWhitespace = "   Hello   "
        Assert.assertEquals("Hello", stringWithLeadingAndTrailingWhitespace.validateString())
    }

}