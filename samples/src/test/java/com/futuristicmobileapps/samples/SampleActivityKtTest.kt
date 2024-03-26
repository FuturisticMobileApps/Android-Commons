package com.futuristicmobileapps.samples

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.futuristicmobilieapps.commons.extensions.android.fields.convertZipCode
import com.nhaarman.mockitokotlin2.argumentCaptor
import org.junit.Test
import org.mockito.Mockito


class EditTextTest {

    @Test
    fun `test zip code is formatted correctly`() {

        val editText = Mockito.mock(EditText::class.java)
        val editable = Mockito.mock(Editable::class.java)
        val textWatcherCaptor = argumentCaptor<TextWatcher>()

        val inputZipCode = "123456789"
        val expectedZipCode = "12345-6789"

        Mockito.`when`(editable.toString()).thenReturn(inputZipCode)

        Mockito.`when`(editText.text).thenReturn(editable)

        editText.convertZipCode()

        Mockito.verify(editText).addTextChangedListener(textWatcherCaptor.capture())
        val textWatcher = textWatcherCaptor.firstValue
        textWatcher.onTextChanged(editable, 0, 0, 0)

        Mockito.verify(editText).setText(expectedZipCode)

    }

}
