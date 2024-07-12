/*
package com.futuristicmobilieapps.commons.extensions.android.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import com.futuristicmobilieapps.commons.R

class Snack private constructor(
    private val activity: Activity,
    private val text: String,
    private val duration: Int = LENGTH_SHORT,
    @ColorRes private val backgroundColor: Int = android.R.color.transparent
) {

    companion object {
        const val LENGTH_SHORT = 2000
        const val LENGTH_LONG = 4000

        fun builder(activity: Activity): Builder {
            return Builder(activity)
        }
    }

    fun show() {
        val view = LayoutInflater.from(activity).inflate(R.layout.chocobar_layout, null)
        val textView = view.findViewById<TextView>(R.id.text)
        textView.text = text

        val layout = activity.findViewById<ViewGroup>(android.R.id.content)
        layout.addView(view)

        view.postDelayed({
            layout.removeView(view)
        }, duration.toLong())
    }

    class Builder(private val activity: Activity) {
        private var text: String = ""
        private var duration: Int = LENGTH_SHORT
        @ColorRes private var backgroundColor: Int = android.R.color.transparent

        fun setText(text: String): Builder {
            this.text = text
            return this
        }

        fun setDuration(duration: Int): Builder {
            this.duration = duration
            return this
        }

        fun setBackgroundColor(@ColorRes backgroundColor: Int): Builder {
            this.backgroundColor = backgroundColor
            return this
        }

        fun build(): ChocoBar {
            return ChocoBar(activity, text, duration, backgroundColor)
        }

        fun show() {
            build().show()
        }
    }
}
*/
