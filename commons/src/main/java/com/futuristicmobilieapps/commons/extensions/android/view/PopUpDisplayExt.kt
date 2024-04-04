package com.futuristicmobilieapps.commons.extensions.android.view

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.content.ContextCompat
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.android.util.tryCatch

fun View.popupDisplay(resourcesId: Int) {
    popupDisplay(context, context.getStringResources(resourcesId))
}

fun View.popupDisplayButton(context: Context, message: String) =
    setOnClickListener { popupDisplay(context, message) }

fun View.popupDisplay(context: Context, message: String) {
    tryCatch {
        hideSoftKeyboard()
        with(ListPopupWindow(context)) {
            setAdapter(ArrayAdapter(context, R.layout.pop_up_display, arrayListOf(message)))
            width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()
            height = LinearLayout.LayoutParams.WRAP_CONTENT
            anchorView = this@popupDisplay
            verticalOffset = 0
            setListSelector(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.rect_dialog_border_layout
                )
            )

            if (!isShowing) show() else dismiss()
        }
    }
}

fun Context.showPopUpWindow(anchorView: View, menuRes: Int): PopupMenu? =
    tryCatch(defaultValue = null) {

        val wrapper = ContextThemeWrapper(this, R.style.MyPopupMenu)
        val popup = PopupMenu(wrapper, anchorView, Gravity.END)
        val fields = popup.javaClass.declaredFields

        if (!fields.isNullOrEmpty()) {

            for (field in fields) {

                if (field != null) {

                    if ("mPopup" == field.name) {

                        field.isAccessible = true

                        val menuPopupHelper = field[popup]

                        val classPopupHelper = Class.forName(menuPopupHelper.javaClass.name)

                        val setForceIcons = classPopupHelper.getMethod(

                            "setForceShowIcon", Boolean::class.javaPrimitiveType
                        )

                        setForceIcons.invoke(menuPopupHelper, true)

                        break
                    }
                }
            }
        }

        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.show()

        return popup

    }


fun TextView?.showPopUpDisplayFromDrawablesRight(stringResId: Int?) {
    if (this == null || stringResId == null) return

    val mContext = this.context ?: return

    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_UP) {
            val drawableRight = 2
            val right = this.right
            val width = this.compoundDrawables[drawableRight].bounds.width()

            if (event.rawX >= right - width) {
                popupDisplay(mContext, mContext.getStringResources(stringResId))
                return@setOnTouchListener true
            } else {
                performClick()
            }
        }
        false
    }
}

