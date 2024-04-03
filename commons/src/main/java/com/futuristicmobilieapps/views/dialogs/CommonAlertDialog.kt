package com.futuristicmobilieapps.views.dialogs

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.futuristicmobilieapps.commons.R
import com.futuristicmobilieapps.commons.databinding.CommonAlertDialogBinding
import com.futuristicmobilieapps.commons.extensions.android.view.onLoadDialog
import com.futuristicmobilieapps.commons.extensions.android.view.setOnClickListeners
import com.futuristicmobilieapps.commons.extensions.android.view.textValue

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

        with(bind) {

            positiveBtnTxt?.let { btnText -> positiveBtn.textValue = btnText }

            negativeBtnTxt?.let { btnText -> negativeBtn.textValue = btnText }

            dialogTitle.textValue = title

            dialogContent.textValue = content

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
