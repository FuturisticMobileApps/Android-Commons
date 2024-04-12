package com.futuristicmobilieapps.views.dialogs

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.databinding.CommonAlertDialogBinding
import com.futuristicmobilieapps.commons.extensions.android.view.onLoadDialog
import com.futuristicmobilieapps.commons.extensions.android.view.setOnClickListeners
import com.futuristicmobilieapps.commons.extensions.kotlin.isValidString


class CommonDialog(
    private val title: String,
    private val message: String,
    private val positiveBtnText: String? = null,
    private val negativeBtnText: String? = null,
    private val onClickPositiveBtn: (() -> Unit)? = null,
    private val onClickNegativeBtn: (() -> Unit)? = null,
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

            if (positiveBtnText.isValidString())

                positiveBtn.setTextForTextView(positiveBtnText)

            if (positiveBtnText.isValidString())

                negativeBtn.setTextForTextView(negativeBtnText)

             dialogTitle.setTextForTextView(title)

            dialogContent.setTextForTextView(message)

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