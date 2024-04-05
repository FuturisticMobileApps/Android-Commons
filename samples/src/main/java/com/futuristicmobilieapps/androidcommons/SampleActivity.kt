package com.futuristicmobilieapps.androidcommons

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.futuristicmobilieapps.commons.extensions.android.util.PermissionLauncher
import com.futuristicmobilieapps.commons.extensions.android.util.showcheckPermission
import com.futuristicmobilieapps.commons.extensions.android.view.setOnClickListeners
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

    val CAMERA = Manifest.permission.CAMERA
    val CALENDAR = Manifest.permission.READ_CALENDAR
    val LOCATION_ACCESS =  Manifest.permission.ACCESS_FINE_LOCATION

    val permissions = arrayOf(CAMERA,CALENDAR,LOCATION_ACCESS)


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
        emailInputLayout = findViewById(R.id.emailInputLayout)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        phoneInputLayout = findViewById(R.id.phoneInputLayout)
        nameInputLayout = findViewById(R.id.nameInputLayout)
        zipCodeInputLayout = findViewById(R.id.zipCodeInputLayout)

        btn = findViewById(R.id.btn)


        btn.setOnClickListeners {

           onePermission()
        }

    }

    private fun onePermission() {

       //  requestPermissionLauncher.launch(CAMERA) //for single permission

        requestPermissionLaunchers.launch(permissions) // for array of permissions

    }


    private fun checkStoragePermission(isGranted: Boolean) {

        showcheckPermission(
            isGranted ,
            CAMERA) {
            click()
        }
    }

    private fun click() {

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

    }

    private val requestPermissionLauncher: PermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->

            checkStoragePermission(isGranted)


        }

    private val requestPermissionLaunchers: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->

            val allGranted = permissions.all { it.value }

            handlePermissionsResult(allGranted)
        }

    private fun handlePermissionsResult(allGranted: Boolean) {

        showcheckPermission(permissions = permissions, allGranted = allGranted){

                click()
            }
        }
    }







