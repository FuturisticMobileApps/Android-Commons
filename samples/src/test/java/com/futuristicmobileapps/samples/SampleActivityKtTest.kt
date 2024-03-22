package com.futuristicmobileapps.samples

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import com.futuristicmobilieapps.androidcommons.R
import com.futuristicmobilieapps.androidcommons.disableView
import com.futuristicmobilieapps.androidcommons.getTextFromTextView
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.android.view.enableView
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.anyBoolean
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


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


@RunWith(MockitoJUnitRunner::class)
class ViewTest {

    @Mock
    lateinit var mockedView: View

    @Mock
    lateinit var mockedTextInputLayout: TextInputLayout

    @Test
    fun testViewIsDisabled() {

        val mockView = mock(View::class.java)

        mockView.enableView()
        // Arrange
//        mockedView.disableView()

        // Assert
        verify(mockView).isEnabled = true
    }

    @Test
    fun testTextInputLayoutIsDisabled() {
        // Arrange
        mockedView.disableView(mockedTextInputLayout)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout).isEnabled = false
    }

    @Test
    fun testTextInputLayoutNotProvided() {
        // Arrange
        mockedView.disableView(null)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout, never()).isEnabled = anyBoolean()
    }

    @Test
    fun testTextInputLayoutEnabledByDefault() {
        // Arrange
        `when`(mockedTextInputLayout.isEnabled).thenReturn(true)

        // Act
        mockedView.disableView(mockedTextInputLayout)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout, never()).isEnabled = anyBoolean()
    }

    @Test
    fun testViewWithNestedTextInputLayout() {
        // Arrange

        // Act
        mockedView.disableView(mockedTextInputLayout)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout).isEnabled = false
    }

    @Test
    fun testTextInputLayoutWithExistingState() {
        // Arrange
        `when`(mockedTextInputLayout.isEnabled).thenReturn(true)

        // Act
        mockedView.disableView(mockedTextInputLayout)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout).isEnabled = true // Should remain unaffected
    }

    @Test
    fun testViewWithNoTextInputLayout() {
        // Arrange

        // Act
        mockedView.disableView(null)

        // Assert
        verify(mockedView).isEnabled = false
        verify(mockedTextInputLayout, never()).isEnabled = anyBoolean()
    }

    @Test
    fun testViewWithMultipleTextInputLayouts() {
        // Arrange
        val mockedTextInputLayout2 = mock(TextInputLayout::class.java)

        // Act
        mockedView.disableView(mockedTextInputLayout)
        mockedView.disableView(mockedTextInputLayout2)

        // Assert
        verify(mockedView, times(2)).isEnabled = false
        verify(mockedTextInputLayout).isEnabled = false
        verify(mockedTextInputLayout2).isEnabled = false
    }

    @Test
    fun testGetStringResourcesWithNonNullId() {
        // Arrange
        val context: Context = ApplicationProvider.getApplicationContext()

        // Act
        val result = context.getStringResources(R.string.app_name)

        // Assert
        assertEquals("Android-Commons", result)
    }

    @Test
    fun testGetStringResourcesWithNullId() {
        // Arrange
        val context: Context = ApplicationProvider.getApplicationContext()
        val stringId: Int? = null

        // Act
        val result = context.getStringResources(stringId)

        // Assert
        assertEquals("", result)
    }
}

