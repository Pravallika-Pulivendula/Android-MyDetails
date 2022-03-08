package com.everest.mydetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTV = findViewById<TextView>(R.id.nameTV)
        val ageTV = findViewById<TextView>(R.id.ageTV)
        val bioTV = findViewById<TextView>(R.id.bioTV)
        val phoneNumberTV = findViewById<TextView>(R.id.phoneNumberTV)

        val data: Bundle? = intent.extras
        val userDetails: UserDetails? = data?.getParcelable(USER_DETAILS);

        val firstName = "Name: " + userDetails?.firstName
        val age = "Age: " + userDetails?.age
        val bio = "Bio: " + userDetails?.bio
        val phoneNumber = "Phno: " + userDetails?.phoneNumber

        nameTV.text = firstName
        ageTV.text = age
        bioTV.text = bio
        phoneNumberTV.text = phoneNumber
    }
}