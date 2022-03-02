package com.everest.mydetails

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val firstName = findViewById<EditText>(R.id.firstNameET)
        val age = findViewById<EditText>(R.id.ageET)
        val bio = findViewById<EditText>(R.id.bioET)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)

        submitButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            if (isInputValid(firstName, age, bio, phoneNumber)) {
                putExtras(intent, firstName, age, bio, phoneNumber)
                startActivity(intent);
            }
        }
    }

    private fun putExtras(
        intent: Intent,
        firstName: EditText,
        age: EditText,
        bio: EditText,
        phoneNumber: EditText
    ) {
        intent.putExtra(FIRST_NAME, firstName.text.toString())
        intent.putExtra(AGE, age.text.toString())
        intent.putExtra(BIO, bio.text.toString())
        intent.putExtra(PHONENUMBER, phoneNumber.text.toString())
    }

    private fun isInputValid(
        firstName: EditText,
        age: EditText,
        bio: EditText,
        phoneNumber: EditText
    ): Boolean {
        if (isDataFilled(
                firstName,
                age,
                bio,
                phoneNumber
            ) && isEmailValid(age) && isPhoneNumberValid(phoneNumber)
        ) {
            return true
        }
        return false
    }


    private fun isDataFilled(
        firstName: EditText,
        age: EditText,
        bio: EditText,
        phoneNumber: EditText
    ): Boolean {
        if (TextUtils.isEmpty(firstName.text) or TextUtils.isEmpty(age.text) or TextUtils.isEmpty(
                bio.text
            ) or TextUtils.isEmpty(phoneNumber.text)
        ) {
            getToastMessage(ALL_FIELDS_REQUIRED_MESSAGE)
            return false
        }
        return true
    }

    private fun isEmailValid(age: EditText): Boolean {
        if (Integer.parseInt(age.text.toString()) > 120) {
            getToastMessage(AGE_TOAST_MESSAGE)
            return false
        }
        return true
    }


    private fun isPhoneNumberValid(phoneNumber: EditText): Boolean {
        if (phoneNumber.length() != 10) {
            getToastMessage(PHONE_NUMBER_TOAST_MESSAGE)
            return false
        }
        return true
    }

    private fun getToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}