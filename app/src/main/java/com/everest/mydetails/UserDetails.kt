package com.everest.mydetails

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class UserDetails(
    var firstName: String,
    var age: Int,
    var bio: String,
    var phoneNumber: String,
) : Parcelable {
}