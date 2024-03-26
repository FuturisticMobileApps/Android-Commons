package com.futuristicmobilieapps.androidcommons

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.futuristicmobilieapps.commons.extensions.android.view.setclicklistener
import com.futuristicmobilieapps.commons.extensions.kotlin.isSignInOrSignUpValidate
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SampleActivity : AppCompatActivity() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var nameEditText: TextInputEditText
    private lateinit var zipCodeEditText: TextInputEditText

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

        // Initialize TextInputLayouts
        emailInputLayout = findViewById(R.id.emailInputLayout)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        phoneInputLayout = findViewById(R.id.phoneInputLayout)
        nameInputLayout = findViewById(R.id.nameInputLayout)
        zipCodeInputLayout = findViewById(R.id.zipCodeInputLayout)

        btn = findViewById(R.id.btn)


        btn.setclicklistener {

            val isValid = isSignInOrSignUpValidate(
                emailEditText = emailEditText,
                passwordEditText = passwordEditText,
                emailInputLayout = emailInputLayout,
                passwordInputLayout = passwordInputLayout
            )

           if(isValid){

           Toast.makeText(this, "SignInSuccess", Toast.LENGTH_SHORT).show()

           } else {

           Toast.makeText(this, "SignInFailed", Toast.LENGTH_SHORT).show()
            }

       }
    }
}

