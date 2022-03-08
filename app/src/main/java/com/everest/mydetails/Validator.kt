package com.everest.mydetails

import android.text.TextUtils

class Validator {
    var homeActivity: HomeActivity = HomeActivity()

    fun isInputValid(
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String
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
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String
    ): Boolean {
        if (TextUtils.isEmpty(firstName) or TextUtils.isEmpty(age.toString()) or TextUtils.isEmpty(
                bio
            ) or TextUtils.isEmpty(phoneNumber)
        ) {
            homeActivity.getToastMessage(homeActivity.getString(R.string.fields_required_toast_message))
            return false
        }
        return true
    }

    private fun isAgeValid(age: Int): Boolean {
        if (age > 120) {
            homeActivity.getToastMessage(homeActivity.getString(R.string.age_toast_message))
            return false
        }
        return true
    }

    private fun isPhoneNumberValid(phoneNumber: String): Boolean {
        if (phoneNumber.length != 10) {
            homeActivity.getToastMessage(homeActivity.getString(R.string.phonenumber_toast_message))
            return false
        }
        return true
    }

}