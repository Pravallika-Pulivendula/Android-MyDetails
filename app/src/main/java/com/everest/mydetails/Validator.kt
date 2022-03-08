package com.everest.mydetails

import android.content.Context
import android.text.TextUtils
import android.widget.Toast

class Validator {

    fun isInputValid(
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String,
        context: Context
    ): Boolean {
        if (isDataFilled(
                firstName,
                age,
                bio,
                phoneNumber,
                context
            ) && isAgeValid(age, context) && isPhoneNumberValid(phoneNumber, context)
        ) {
            return true
        }
        return false
    }

    private fun isDataFilled(
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String,
        context: Context
    ): Boolean {
        if (TextUtils.isEmpty(firstName) or TextUtils.isEmpty(age.toString()) or TextUtils.isEmpty(
                bio
            ) or TextUtils.isEmpty(phoneNumber)
        ) {
            getToastMessage(context, context.getString(R.string.fields_required_toast_message))
            return false
        }
        return true
    }

    private fun isAgeValid(age: Int, context: Context): Boolean {
        if (age > 120) {
            getToastMessage(context, context.getString(R.string.age_toast_message))
            return false
        }
        return true
    }

    private fun isPhoneNumberValid(phoneNumber: String, context: Context): Boolean {
        if (phoneNumber.length != 10) {
            getToastMessage(context, context.getString(R.string.phonenumber_toast_message))
            return false
        }
        return true
    }

    private fun getToastMessage(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}