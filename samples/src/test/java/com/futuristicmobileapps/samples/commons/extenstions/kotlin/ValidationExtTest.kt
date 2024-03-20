package com.futuristicmobileapps.samples.commons.extenstions.kotlin

import com.futuristicmobilieapps.commons.extensions.kotlin.isCorrectEIN
import com.futuristicmobilieapps.commons.extensions.kotlin.isRepeatedChar
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidEIN
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidEmail
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidName
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidPassword
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidPhone
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidZipCode
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ValidationExtTest{

    @Test
    fun `isValidName should return true for valid names`() {
        assertTrue("John Doe".isValidName())
        assertTrue("Alice-Smith".isValidName())
        assertTrue("123456".isValidName())
        assertTrue("#Name123".isValidName())
        assertTrue("A&B Company".isValidName())
    }

    @Test
    fun `isValidName should return false for invalid names`() {
        assertFalse("JohnDoe$".isValidName())
        assertFalse("Name@".isValidName())
        assertFalse("".isValidName())
        assertFalse("VeryLongNameThatExceedsSeventyFiveCharactersLimit123456789012345678901234567890123456789012345678901234567890".isValidName())
    }

    @Test
    fun `isValidPhone should return true for valid phone numbers`() {
        assertTrue("(123) 456-7890".isValidPhone())
        assertTrue("(555) 555-5555".isValidPhone())
        assertTrue("(999) 999-9999".isValidPhone())
    }

    @Test
    fun `isValidPhone should return false for invalid phone numbers`() {
        assertFalse("1234567890".isValidPhone())
        assertFalse("(123) 45-67890".isValidPhone())
        assertFalse("(000) 123-4567".isValidPhone())
        assertFalse("(123) 456-789".isValidPhone())
    }

    @Test
    fun `isValidPassword should return true for valid passwords`() {
        assertTrue("Passw0rd!".isValidPassword())
        assertTrue("Abc@123".isValidPassword())
        assertTrue("Secret123@".isValidPassword())
        assertTrue("P@ssw0rd".isValidPassword())
    }

    @Test
    fun `isValidPassword should return false for invalid passwords`() {
        assertFalse("password".isValidPassword())
        assertFalse("PASSWORD".isValidPassword())
        assertFalse("12345678".isValidPassword())
        assertFalse("Pass".isValidPassword())
        assertFalse("Abcdefg".isValidPassword())
    }


    @Test
    fun `isValidEIN should return true for valid EINs`() {
        assertTrue("12-3456789".isValidEIN())
        assertTrue("55-3456780".isValidEIN())
        assertTrue("98-3456781".isValidEIN())
    }

    @Test
    fun `isValidEIN should return false for invalid EINs`() {
        assertFalse("12-345678".isValidEIN())
        assertFalse("123-4567890".isValidEIN())
        assertFalse("1-23456789".isValidEIN())
        assertFalse("12-34567A9".isValidEIN())
        assertFalse("1234-56789".isValidEIN())
        assertFalse("12-34567890".isValidEIN())
    }

    @Test
    fun `isRepeatedChar should return true for strings with repeated characters`() {
        assertTrue("aaaa".isRepeatedChar())
        assertTrue("1111".isRepeatedChar())
        assertTrue("   ".isRepeatedChar())
        assertTrue("".isRepeatedChar())
        assertTrue(null.isRepeatedChar())
    }

    @Test
    fun `isRepeatedChar should return false for strings with non-repeated characters`() {
        assertFalse("abcde".isRepeatedChar())
        assertFalse("12345".isRepeatedChar())
        assertFalse("ababab".isRepeatedChar())
        assertFalse("aabbcc".isRepeatedChar())
    }

    @Test
    fun `isCorrectEIN should return true for correct EINs`() {
        assertTrue("12-3456789".isCorrectEIN())
        assertTrue("67-8657780".isCorrectEIN())
    }

    @Test
    fun `isCorrectEIN should return false for invalid EINs`() {
        assertFalse("123-456789".isCorrectEIN())
        assertFalse("12-345678".isCorrectEIN())
        assertFalse("123456789".isCorrectEIN())
        assertFalse("12-345678".isCorrectEIN())
        assertFalse("123456789".isCorrectEIN())
        assertFalse("07-1234567".isCorrectEIN())
        assertFalse("".isCorrectEIN())
        assertFalse(null.isCorrectEIN())
    }


    @Test
    fun `valid email addresses should return true`() {
        assertTrue("user@example.com".isValidEmail())
        assertTrue("user.name+tag@example.com".isValidEmail())
        assertTrue("user@subdomain.example.com".isValidEmail())
    }

    @Test
    fun `invalid email addresses should return false`() {
        assertFalse("".isValidEmail())
        assertFalse(null.isValidEmail())
        assertFalse("user@example".isValidEmail())
        assertFalse("user@.com".isValidEmail())
        assertFalse("user@domain".isValidEmail())
        assertFalse("user@example.123".isValidEmail())
        assertFalse("user@exam+ple.com".isValidEmail())
    }

    @Test
    fun `valid zip codes should return true`() {
        assertTrue("12345".isValidZipCode())
        assertTrue("12345-6789".isValidZipCode())
    }

    @Test
    fun `invalid zip codes should return false`() {
        assertFalse("".isValidZipCode())
        assertFalse(null.isValidZipCode())
        assertFalse("123456".isValidZipCode())
        assertFalse("1234".isValidZipCode())
        assertFalse("12345-67890".isValidZipCode())
        assertFalse("12345-678".isValidZipCode())
        assertFalse("123456789".isValidZipCode())
    }
}