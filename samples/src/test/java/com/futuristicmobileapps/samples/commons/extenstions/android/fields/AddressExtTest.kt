package com.futuristicmobileapps.samples.commons.extenstions.android.fields

import android.text.Editable
import android.widget.EditText
import com.futuristicmobilieapps.commons.extensions.android.fields.convertZipCode
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class EditTextTest {

    // Declare editText variable
    private lateinit var editText: EditText

    @Test
    fun testConvertZipCode_ValidZipCode() {

        editText = mock(EditText::class.java)
        // Arrange
        val initialText = "1234567890"
        val editableText: Editable = mock(Editable::class.java)

        // Stub behavior for editText
        `when`(editText.text).thenReturn(editableText)
        `when`(editableText.toString()).thenReturn(initialText)

        // Act
        editText.convertZipCode()

        // Assert
        verify(editText).setText("12345-6789")
    }


}











