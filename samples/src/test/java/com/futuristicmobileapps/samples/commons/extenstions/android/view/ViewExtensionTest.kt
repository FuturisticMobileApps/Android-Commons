package com.futuristicmobileapps.samples.commons.extenstions.android.view

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.android.view.check
import com.futuristicmobilieapps.commons.extensions.android.view.disableAllChildViews
import com.futuristicmobilieapps.commons.extensions.android.view.disableAllViews
import com.futuristicmobilieapps.commons.extensions.android.view.disableView
import com.futuristicmobilieapps.commons.extensions.android.view.enableView
import com.futuristicmobilieapps.commons.extensions.android.view.gone
import com.futuristicmobilieapps.commons.extensions.android.view.invisible
import com.futuristicmobilieapps.commons.extensions.android.view.isViewGroup
import com.futuristicmobilieapps.commons.extensions.android.view.setOnClickListeners
import com.futuristicmobilieapps.commons.extensions.android.view.textForTextView
import com.futuristicmobilieapps.commons.extensions.android.view.unCheck
import com.futuristicmobilieapps.commons.extensions.android.view.visible
import com.futuristicmobilieapps.commons.extensions.android.view.visibleAndCheck
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.w3c.dom.Text


class ViewExtensionTest {

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
    fun `testExtensions_disableChildViews`() {

        val view: View = mock(View::class.java)

        view.disableAllChildViews()

        verify(view).isEnabled = false
    }


    /** Disable all child views extension test cases */


    @Test
    fun `disableAllChildViews disables all child views`() {

        // Mock the views
        val rootView = mock(ViewGroup::class.java)
        val childView1 = mock(View::class.java)
        val childView2 = mock(View::class.java)
        val childView3 = mock(View::class.java)

        // Set up the view hierarchy
        `when`(rootView.childCount).thenReturn(3)
        `when`(rootView.getChildAt(0)).thenReturn(childView1)
        `when`(rootView.getChildAt(1)).thenReturn(childView2)
        `when`(rootView.getChildAt(2)).thenReturn(childView3)

        // Execute the function
        rootView.disableAllChildViews()

        // Verify that isEnabled is set to false for all child views

        verify(rootView).isEnabled = false
        verify(childView1).isEnabled = false
        verify(childView2).isEnabled = false

    }


    /** Disable all views extension test cases  */
    @Test
    fun `test disabling all views in a ViewGroup using assertion`() {

        val relativeLayout = mock(RelativeLayout::class.java)
        val linearLayout = mock(LinearLayout::class.java)
        val view = mock(View::class.java)
        val childView1 = mock(View::class.java)
        val childView2 = mock(View::class.java)
        val checkbox = mock(CheckBox::class.java)
        val radioBtn = mock(RadioButton::class.java)

        val textView = mock(TextView::class.java)


        // Given
        // layout's ViewGroup 1
        `when`(relativeLayout.childCount).thenReturn(2)
        `when`(relativeLayout.getChildAt(0)).thenReturn(view)
        `when`(relativeLayout.getChildAt(1)).thenReturn(linearLayout)

        // layout's ViewGroup 2
        `when`(linearLayout.childCount).thenReturn(6)
        `when`(linearLayout.getChildAt(0)).thenReturn(childView1)
        `when`(linearLayout.getChildAt(1)).thenReturn(childView2)
        `when`(linearLayout.getChildAt(2)).thenReturn(checkbox)
        `when`(linearLayout.getChildAt(3)).thenReturn(radioBtn)
        `when`(linearLayout.getChildAt(4)).thenReturn(textView)


        // When
        relativeLayout.disableAllViews()


        // Then
        verify(relativeLayout).isEnabled = false
        verify(view).isEnabled = false
        verify(linearLayout).isEnabled = false
        verify(childView1).isEnabled = false
        verify(childView2).isEnabled = false
        verify(radioBtn).isEnabled = false
        verify(checkbox).isEnabled = false
        verify(textView).isEnabled = true
    }


    // enableView() with textinputLayout passed as parameter
    @Test
    fun testEnableView() {
        // Mock a View and TextInputLayout
        val view = mock(View::class.java)
        val resources = mock(Resources::class.java)
        val textInputLayout = mock(TextInputLayout::class.java)
        val context = mock(Context::class.java)
        val transparentColor = R.color.transparent


        // Given
        `when`(textInputLayout.context).thenReturn(context)
        `when`(textInputLayout.context.resources).thenReturn(resources)
        `when`(ContextCompat.getColor(context, transparentColor)).thenReturn(transparentColor)
        `when`(textInputLayout.boxBackgroundColor).thenReturn(transparentColor)
//        `when`((textInputLayout.boxBackgroundColor as ColorDrawable).color).thenReturn(Color.TRANSPARENT)

        // Call the extension function
        view.enableView(textInputLayout)

        // Verify isEnabled property is set to true
        verify(view).isEnabled = true

        // Verify background color is set correctly
        verify(textInputLayout).boxBackgroundColor = transparentColor
    }

    @Test
    fun testDisableView() {

        val view = mock(View::class.java)
        val resources = mock(Resources::class.java)
        val textInputLayout = mock(TextInputLayout::class.java)
        val context = mock(Context::class.java)
        val disabledColor = R.color.disabled_color


        // Given
        `when`(textInputLayout.context).thenReturn(context)
        `when`(textInputLayout.context.resources).thenReturn(resources)
        `when`(ContextCompat.getColor(context, disabledColor)).thenReturn(disabledColor)
        `when`(textInputLayout.boxBackgroundColor).thenReturn(disabledColor)


        // Call the extension function
        view.disableView(textInputLayout)

        // Verify isEnabled property is set to true
        verify(view).isEnabled = false


        //verify the boxBackground of TextInputLayout
        verify(textInputLayout).boxBackgroundColor = disabledColor

    }

    @Test
    fun testSetOnClickListeners() {
        // mock view
        val view = mock(View::class.java)

        //define lambda scope of the clicklistener to do nothing but only to execute
        val onClickListeners: (View) -> Unit = {

        }

        // Create an instance of the extension function
        view.setOnClickListeners(onClickListeners)

        // Simulate two consecutive clicks
        view.performClick() // First click
        assertFalse(view.hasOnClickListeners()) // Check if click listener is set

        // Advance the clock by 1000 milliseconds
        Thread.sleep(1000)

        view.performClick() // Second click within 2000ms
        assertFalse(view.hasOnClickListeners()) // Check if click listener is removed

        // Advance the clock by another 2000 milliseconds
        Thread.sleep(2000)

        // Simulate another click after 2000ms
        view.performClick()
        assertFalse(view.hasOnClickListeners()) // Check if click listener is set again
    }

    @Test
    fun testTextFromTextView(){
        val textView = mock(TextView::class.java)
        val expectedText = "Hello World"

        textView.text = "Hello"

        `when`(textView.text).thenReturn("jello")
        // When
        textView.textForTextView

        // Then
        verify(textView).text = expectedText
    }


}

