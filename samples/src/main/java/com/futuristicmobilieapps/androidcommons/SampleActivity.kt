package com.futuristicmobilieapps.androidcommons

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.futuristicmobilieapps.commons.extensions.android.fields.convertToUsPhoneNumber
import com.futuristicmobilieapps.commons.extensions.android.util.getStringResources
import com.futuristicmobilieapps.commons.extensions.android.view.setclicklistener
import com.futuristicmobilieapps.commons.extensions.kotlin.CommonAlertDialog
import com.futuristicmobilieapps.commons.extensions.kotlin.popupDisplay
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SampleActivity : AppCompatActivity() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var nameEditText: TextInputEditText
    private lateinit var zipCodeEditText: TextInputEditText
    private lateinit var tvTest: EditText


    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var phoneInputLayout: TextInputLayout
    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var zipCodeInputLayout: TextInputLayout

    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_activity)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        nameEditText = findViewById(R.id.nameEditText)
        zipCodeEditText = findViewById(R.id.zipCodeEditText)
        tvTest = findViewById(R.id.tvTest)

        // Initialize TextInputLayouts
        emailInputLayout = findViewById(R.id.emailInputLayout)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        phoneInputLayout = findViewById(R.id.phoneInputLayout)
        nameInputLayout = findViewById(R.id.nameInputLayout)
        zipCodeInputLayout = findViewById(R.id.zipCodeInputLayout)

        btn = findViewById(R.id.btn)


        btn.setclicklistener {


            CommonAlertDialog(
                title = getStringResources(R.string.alert_text),
                content = getStringResources(R.string.business_not_delete),
                singleButton = true
            ).show(this.supportFragmentManager, "AddressBook_delete_popUp")

            /*val isValid = isSignInOrSignUpValidate(
                emailEditText = emailEditText, emailInputLayout = emailInputLayout)

            Log.i("check", "onCreate:$isValid ")

           if(isValid){

           Toast.makeText(this, "SignInSuccess", Toast.LENGTH_SHORT).show()

           } else {

           Toast.makeText(this, "SignInFailed", Toast.LENGTH_SHORT).show()
            }*/

       }

        tvTest.popupDisplay(this,"check")
    }
}

