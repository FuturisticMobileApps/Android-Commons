package com.futuristicmobilieapps.commons.extensions.kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.content.ContextCompat
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources

fun View.popupDisplay(resourcesId: Int) {

    popupDisplay(context, context.getStringResources(resourcesId))

}

fun View.popupDisplay(
    context: Context,
    message: String
) {

    try {

        hideSoftKeyBoard()

        val popupWindow = ListPopupWindow(context)

        popupWindow.setAdapter(ArrayAdapter(context, R.layout.pop_up_display, arrayListOf(message)))

        popupWindow.width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()

        popupWindow.height = LinearLayout.LayoutParams.WRAP_CONTENT

        popupWindow.anchorView = this

        popupWindow.verticalOffset = 0

        popupWindow.setListSelector(ContextCompat.getDrawable(

                context, R.drawable.rect_dialog_border_layout
            )
        )

        if (!popupWindow.isShowing) popupWindow.show()

        else popupWindow.dismiss()

    } catch (e: Exception) {

        e.printStackTrace()

    }

}


fun Context?.showPopUpWindow(anchorView: View?, menuRes: Int?): PopupMenu? {

    if (this == null || anchorView == null || menuRes == null) return null

    try {

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

    } catch (e: Exception) {

        e.printStackTrace()

        return null
    }
}

@SuppressLint("ClickableViewAccessibility")
fun TextView?.showPopUpDisplayFromDrawableRight(stringResId: Int?) {

    if (this == null || stringResId == null) return


    val mContext = this.context ?: return

    setOnTouchListener(View.OnTouchListener { _, event ->

        if (event.action == MotionEvent.ACTION_UP) {

            val drawableRight = 2
            val right = this.right
            val width = this.compoundDrawables[drawableRight].bounds.width()

            if (event.rawX >= right - width) {

                popupDisplay(
                    mContext, mContext.getStringResources(stringResId)
                )

                return@OnTouchListener true
            }
        }

        false
    })
}


fun View.popupDisplayButton(context: Context, message: String) = setOnClickListener { popupDisplay(context, message) }


fun View.hideSoftKeyBoard() {

    try {

        (context.getSystemService(

            Context.INPUT_METHOD_SERVICE

        ) as InputMethodManager?)?.hideSoftInputFromWindow(

            this.windowToken, 0
        )


    } catch (e: java.lang.Exception) {

        e.printStackTrace()
    }
}


