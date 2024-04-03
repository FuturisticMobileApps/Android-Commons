package com.futuristicmobilieapps.commons.extensions.kotlin

import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.databinding.CommonAlertDialogBinding
import com.futuristicmobilieapps.commons.extensions.android.view.setOnClickListeners

fun AppCompatDialogFragment.onLoadDialog(
    isFullScreen: Boolean = true,
    isAutoCancel: Boolean = true
): Dialog {

    return Dialog(requireContext(), R.style.DialogFragmentStyle).apply {

        val widthHeight =
            if (isFullScreen) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT

        setContentView(

            LinearLayout(requireContext()).apply {

                layoutParams = ViewGroup.LayoutParams(widthHeight, widthHeight)
            }
        )

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        window?.setLayout(widthHeight, widthHeight)

        isCancelable = isAutoCancel

        setCanceledOnTouchOutside(isAutoCancel)
    }
}

fun AppCompatDialogFragment.showDialog(fragmentManager: FragmentManager, tag: String) {

    val fragment = fragmentManager.findFragmentByTag(tag)

    if (!fragment?.isAdded.validateBoolean()) show(fragmentManager, tag)
}

fun AppCompatDialogFragment.showDialog(activity: AppCompatActivity, tag: String) {

    showDialog(activity.supportFragmentManager, tag)
}

fun AppCompatDialogFragment.showDialog(activity: FragmentActivity, tag: String) {

    showDialog(activity.supportFragmentManager, tag)
}


class CommonAlertDialog(
    private val title: String,
    private val content: String,
    private val positiveBtnTxt: String? = null,
    private val negativeBtnTxt: String? = null,
    private val singleButton: Boolean = false,
    private val cancelableForBackButton: Boolean = false,
    private val closeIconVisibility: Boolean = false,
    private val onClickPositiveBtn: (() -> Unit)? = null,
    private val onClickNegativeBtn: (() -> Unit)? = null,
    private val onClickSingleBtn: (() -> Unit)? = null,
) : AppCompatDialogFragment(R.layout.common_alert_dialog) {

    private lateinit var bind: CommonAlertDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?) =
        onLoadDialog(isFullScreen = false, isAutoCancel = false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        bind = CommonAlertDialogBinding.bind(view)

        loadLecture()

    }

    private fun loadLecture() {

        setTextFields()

        setOnClickListeners()

    }

    private fun setTextFields() {

        bind.apply {

            if (positiveBtnTxt.isValidString())

                positiveBtn.setTextForTextView(positiveBtnTxt)

            if (positiveBtnTxt.isValidString())
                negativeBtn.setTextForTextView(negativeBtnTxt)

            dialogTitle.setTextForTextView(title)

            dialogContent.setTextForTextView(content)

        }

    }

    private fun setOnClickListeners() {

        bind.apply {

            ivClose.setOnClickListeners {

                onClickNegativeBtn?.invoke()

                dismiss()

            }

            negativeBtn.setOnClickListener {

                onClickNegativeBtn?.invoke()

                dismiss()

            }

            positiveBtn.setOnClickListener {

                onClickPositiveBtn?.invoke()

                dismiss()

            }

        }

    }

    private fun DialogFragment.setWidthPercent(percentage: Int) {

        val percent = percentage.toFloat() / 100

        val dm = Resources.getSystem().displayMetrics

        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }

        val percentWidth = rect.width() * percent

        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    override fun onResume() {

        super.onResume()

        setWidthPercent(85)

    }

}

fun TextView.setTextForTextView(input: String?) {

    text = input

}