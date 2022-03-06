package com.everest.mydetails

import android.text.TextUtils
import android.widget.EditText

class Validator {
    var homeActivity: HomeActivity = HomeActivity()

    fun isInputValid(
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
            ) && isAgeValid(age) && isPhoneNumberValid(phoneNumber)
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
            homeActivity.getToastMessage(homeActivity.getString(R.string.fields_required_toast_message))
            return false
        }
        return true
    }

    private fun isAgeValid(age: EditText): Boolean {
        if (Integer.parseInt(age.text.toString()) > 120) {
            homeActivity.getToastMessage(homeActivity.getString(R.string.age_toast_message))
            return false
        }
        return true
    }

    private fun isPhoneNumberValid(phoneNumber: EditText): Boolean {
        if (phoneNumber.length() != 10) {
            homeActivity.getToastMessage(homeActivity.getString(R.string.phonenumber_toast_message))
            return false
        }
        return true
    }

}