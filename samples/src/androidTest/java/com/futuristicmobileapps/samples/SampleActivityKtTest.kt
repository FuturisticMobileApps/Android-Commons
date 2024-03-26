package com.futuristicmobileapps.samples

import android.widget.TextView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.futuristicmobilieapps.androidcommons.R
import com.futuristicmobilieapps.androidcommons.SampleActivity
import com.futuristicmobilieapps.commons.extensions.android.fields.getTextFromTextView
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SampleActivityKtTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<SampleActivity> =
        ActivityScenarioRule(SampleActivity::class.java)

    @Test
    fun getTextFromTextViewWithValidText() {
        activityRule.scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.tvTest)
            textView.text = "Hello"
            Assert.assertEquals("Hello", textView.getTextFromTextView())
        }
    }

    @Test
    fun getTextFromTextViewWithEmptyText() {
        activityRule.scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.tvTest)
            textView.text = ""
            Assert.assertEquals("", textView.getTextFromTextView())
        }
    }

    @Test
    fun getTextFromTextViewWithNullText() {
        activityRule.scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.tvTest)
            textView.text = null
            Assert.assertEquals("", textView.getTextFromTextView())
        }
    }

    @Test
    fun getTextFromTextViewWithTextContainingLeadingAndTrailingWhitespace() {
        activityRule.scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.tvTest)
            textView.text = "   Hello   "
            Assert.assertEquals("Hello", textView.getTextFromTextView())
        }
    }
}