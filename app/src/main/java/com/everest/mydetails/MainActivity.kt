package com.everest.mydetails

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorDrawable = ColorDrawable(Color.parseColor("#0F9D58"))
        supportActionBar?.setBackgroundDrawable(colorDrawable)

        val nameTV = findViewById<TextView>(R.id.nameTV)
        val ageTV = findViewById<TextView>(R.id.ageTV)
        val bioTV = findViewById<TextView>(R.id.bioTV)
        val phoneNumberTV = findViewById<TextView>(R.id.phoneNumberTV)

        val firstName = "Name: " + intent.getStringExtra(FIRST_NAME)
        val age = "Age: " + intent.getStringExtra(AGE)
        val bio = "Bio: " + intent.getStringExtra(BIO)
        val phoneNumber = "Phno: " + intent.getStringExtra(PHONENUMBER)

        nameTV.text = firstName
        ageTV.text = age
        bioTV.text = bio
        phoneNumberTV.text = phoneNumber
    }
}