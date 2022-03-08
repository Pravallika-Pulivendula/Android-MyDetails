package com.everest.mydetails

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    var validator: Validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val firstName = findViewById<EditText>(R.id.firstNameET)
        val age = findViewById<EditText>(R.id.ageET)
        val bio = findViewById<EditText>(R.id.bioET)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            submitData(
                firstName.text.toString(),
                Integer.parseInt(age.text.toString()),
                bio.text.toString(),
                phoneNumber.text.toString()
            )
        }

    }

    private fun submitData(
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String
    ) {
        val intent = Intent(this, MainActivity::class.java)
        if (validator.isInputValid(
                firstName,
                age,
                bio,
                phoneNumber,
                this
            )
        ) {
            intent.putExtra(
                USER_DETAILS, UserDetails(
                    firstName,
                    age,
                    bio,
                    phoneNumber
                )
            )
            startActivity(intent);
        }
    }
}