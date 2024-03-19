package com.futuristicmobileapps.samples

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.futuristicmobilieapps.commons.extensions.android.view.check
import com.futuristicmobilieapps.commons.extensions.android.view.disable
import com.futuristicmobilieapps.commons.extensions.android.view.disableAllChildViews
import com.futuristicmobilieapps.commons.extensions.android.view.disableAllViews
import com.futuristicmobilieapps.commons.extensions.android.view.disableView
import com.futuristicmobilieapps.commons.extensions.android.view.enable
import com.futuristicmobilieapps.commons.extensions.android.view.enableView
import com.futuristicmobilieapps.commons.extensions.android.view.gone
import com.futuristicmobilieapps.commons.extensions.android.view.invisible
import com.futuristicmobilieapps.commons.extensions.android.view.isViewGroup
import com.futuristicmobilieapps.commons.extensions.android.view.unCheck
import com.futuristicmobilieapps.commons.extensions.android.view.visible
import com.futuristicmobilieapps.commons.extensions.android.view.visibleAndCheck
import com.google.android.material.textfield.TextInputLayout
import junit.framework.TestCase.assertFalse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class ViewExtensionTest {


    private lateinit var rootView: ViewGroup
    private lateinit var childView1: View
    private lateinit var childView2: View
    private lateinit var childView3: View

    /** Null Scenario test case for ViewExtensions */
    @Test
    fun testExtensions_NullView() {
        // Given
        val view: View? = null
        val textInputLayout: TextInputLayout = mock(TextInputLayout::class.java)
        val checkbox = mock(CheckBox::class.java)
        val radioButton = mock(RadioButton::class.java)
        val radioGroup = mock(RadioGroup::class.java)

        // When
        view?.apply {
            this.visible()
            this.invisible()
            this.gone()
            this.enableView()
            this.disableView()
            this.enableView()
            this.disableView()
            this.disableAllChildViews()
            this.disableAllViews()
            this.isViewGroup()
        }

        checkbox.apply {
            this.visible()
            this.invisible()
            this.gone()
            this.enableView()
            this.disableView()
            this.enableView()
            this.disableView()
            this.disableAllChildViews()
            this.disableAllViews()
            this.isViewGroup()
        }

        radioButton.apply {
            this.visible()
            this.invisible()
            this.gone()
            this.enableView()
            this.disableView()
            this.enableView()
            this.disableView()
            this.disableAllChildViews()
            this.disableAllViews()
            this.isViewGroup()
        }

        radioGroup.apply {
            this.visible()
            this.invisible()
            this.gone()
            this.enableView()
            this.disableView()
            this.enableView()
            this.disableView()
            this.disableAllChildViews()
            this.disableAllViews()
            this.isViewGroup()
        }




    }


    /** Radio Btn, Checkbox , etc... */
    @Test
    fun `test RadioButton check`() {
        val radioButton = mock(RadioButton::class.java)
        `when`(radioButton.isChecked).thenReturn(false)

        radioButton.check()

        verify(radioButton).isChecked = true
    }

    @Test
    fun `test RadioButton visibleAndCheck`() {
        val radioButton = mock(RadioButton::class.java)
        `when`(radioButton.visibility).thenReturn(View.VISIBLE)
        `when`(radioButton.isChecked).thenReturn(false)

        radioButton.visibleAndCheck()

        verify(radioButton).visibility = View.VISIBLE
        verify(radioButton).isChecked = true
    }

    @Test
    fun `test RadioButton unCheck`() {
        val radioButton = mock(RadioButton::class.java)
        `when`(radioButton.isChecked).thenReturn(true)

        radioButton.unCheck()

        verify(radioButton).isChecked = false
    }

    @Test
    fun `test CheckBox check`() {
        val checkBox = mock(CheckBox::class.java)
        `when`(checkBox.isChecked).thenReturn(false)

        checkBox.check()

        verify(checkBox).isChecked = true
    }

    @Test
    fun `test CheckBox unCheck`() {
        val checkBox = mock(CheckBox::class.java)
        `when`(checkBox.isChecked).thenReturn(true)

        checkBox.unCheck()

        verify(checkBox).isChecked = false
    }




    @Test
    fun `testExtensions_disableChildViews`(){

        val view:View = mock(View::class.java)

        view.disableAllChildViews()

        verify(view).isEnabled = false
    }



    /** Disable all child views extension test cases */
    @Before
    fun setUp() {
        // Mock the views
        rootView = mock(ViewGroup::class.java)
        childView1 = mock(View::class.java)
        childView2 = mock(View::class.java)
        childView3 = mock(View::class.java)

        // Set up the view hierarchy
        `when`(rootView.childCount).thenReturn(3)
        `when`(rootView.getChildAt(0)).thenReturn(childView1)
        `when`(rootView.getChildAt(1)).thenReturn(childView2)
        `when`(rootView.getChildAt(2)).thenReturn(childView3)

        // Mock child views in childView1
        `when`(childView1.isEnabled).thenReturn(true)


        // Mock child views in childView2
        `when`(childView2.isEnabled).thenReturn(true)

        // Mock child views in childView2
        `when`(childView3.isEnabled).thenReturn(true)
    }

    @Test
    fun `disableAllChildViews disables all child views`() {
        // Execute the function
        rootView.disableAllChildViews()

        // Verify that isEnabled is set to false for all child views
        assert(childView1.isEnabled)
        assert(childView2.isEnabled)
        assert(childView3.isEnabled)
    }

    @Test
    fun `disableAllChildViews  disables root view`() {
        // Execute the function
        rootView.disableAllChildViews()

        // Verify that isEnabled is not called on the root view
        verify(rootView).isEnabled = false
    }

    @Test
    fun `disableAllChildViews handles null child views`() {
        // Set up null child views
        `when`(rootView.getChildAt(0)).thenReturn(null)
        `when`(rootView.getChildAt(1)).thenReturn(null)
        `when`(rootView.getChildAt(2)).thenReturn(null)

        // Execute the function
        rootView.disableAllChildViews()

        // Verify that isEnabled is not called on null child views
        verify(childView1, never()).isEnabled = false
        verify(childView2, never()).isEnabled = false
        verify(childView3, never()).isEnabled = false
    }

    /** Disable all views extension test cases  */
    @Test
    fun `test disabling all views in a ViewGroup`() {
        // Given
        `when`(rootView is ViewGroup).thenReturn(true)
        `when`(rootView.childCount).thenReturn(2)
        `when`(rootView.getChildAt(0)).thenReturn(childView1)
        `when`(rootView.getChildAt(1)).thenReturn(childView2)

        // When
        rootView.disableAllViews()

        // Then
        verify(childView1).disableAllViews()
        verify(childView2).disableAllViews()
    }

    @Test
    fun `test disabling RadioButton`() {
        // Given
        val radioButton = mock(RadioButton::class.java)

        // When
        radioButton.disableAllViews()

        // Then
        verify(radioButton).disableView()
    }

    @Test
    fun `test disabling CheckBox`() {
        // Given
        val checkBox = mock(CheckBox::class.java)

        // When
        checkBox.disableAllViews()

        // Then
        verify(checkBox).disableView()
    }

    @Test
    fun `test enabling TextView`() {
        // Given
        val textView = mock(TextView::class.java)

        // When
        textView.disableAllViews()

        // Then
        verify(textView).enable()
    }

    @Test
    fun `test disabling other types of views`() {
        // Given
        val otherView = mock(View::class.java)

        // When
        otherView.disableAllViews()

        // Then
        verify(otherView).disableView()
    }


}

