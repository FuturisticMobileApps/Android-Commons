package com.futuristicmobileapps.samples.commons.extenstions.android.fields

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.futuristicmobilieapps.commons.extensions.android.fields.convertToEIN
import com.futuristicmobilieapps.commons.extensions.android.fields.convertZipCode
import com.futuristicmobilieapps.commons.extensions.android.fields.ssnMasking
import com.nhaarman.mockitokotlin2.argumentCaptor
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EditTextTest {

    @Test
    fun `test zip code is formatted correctly`() {

        val editText = mock(EditText::class.java)
        val editable = mock(Editable::class.java)
        val textWatcherCaptor = argumentCaptor<TextWatcher>()

        val inputZipCode = "123456789"
        val expectedZipCode = "12345-6789"

        `when`(editable.toString()).thenReturn(inputZipCode)

        `when`(editText.text).thenReturn(editable)

        editText.convertZipCode()

        verify(editText).addTextChangedListener(textWatcherCaptor.capture())
        val textWatcher = textWatcherCaptor.firstValue
        textWatcher.onTextChanged(editable, 0, 0, 0)

        verify(editText).setText(expectedZipCode)

    }

    @Test
    fun `test ConvertEIN`() {

        val ein = mock(EditText::class.java)
        val editable = mock(Editable::class.java)
        val textWatcherCaptor = argumentCaptor<TextWatcher>()

        val inputEIN = "123456789"
        val expectedEIN = "12-3456789"

        `when`(editable.toString()).thenReturn(inputEIN)

        `when`(ein.text).thenReturn(editable)

        ein.convertToEIN()

        verify(ein).addTextChangedListener(textWatcherCaptor.capture())
        val textWatcher = textWatcherCaptor.firstValue
        textWatcher.onTextChanged(editable, 0, 0, 0)

        verify(ein).setText(expectedEIN)

    }

    @Test
    fun `test ssnMasking`() {

        val ssn = mock(EditText::class.java)
        val editable = mock(Editable::class.java)
        val textWatcherCaptor = argumentCaptor<TextWatcher>()

        val inputSSN = "123456789"
        val expectedSSN = "123-45-6789"

        `when`(editable.toString()).thenReturn(inputSSN)

        `when`(ssn.text).thenReturn(editable)

        ssn.ssnMasking()

        verify(ssn).addTextChangedListener(textWatcherCaptor.capture())
        val textWatcher = textWatcherCaptor.firstValue
        textWatcher.onTextChanged(editable, 0, 0, 0)

        verify(ssn).setText(expectedSSN)

    }
}











