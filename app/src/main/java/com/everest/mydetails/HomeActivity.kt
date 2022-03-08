package com.everest.mydetails

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    var submitButton: Button = findViewById(R.id.submitButton)
    var validator: Validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val firstName = findViewById<EditText>(R.id.firstNameET)
        val age = findViewById<EditText>(R.id.ageET)
        val bio = findViewById<EditText>(R.id.bioET)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)

        submitData(
            firstName.text.toString(),
            Integer.parseInt(age.text.toString()),
            bio.text.toString(),
            phoneNumber.text.toString()
        )
    }

    private fun submitData(
        firstName: String,
        age: Int,
        bio: String,
        phoneNumber: String
    ) {
        submitButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            if (validator.isInputValid(firstName, age, bio, phoneNumber)) {
                intent.putExtra(FIRST_NAME, firstName)
                intent.putExtra(AGE, age.toString())
                intent.putExtra(BIO, bio)
                intent.putExtra(PHONENUMBER, phoneNumber)
                startActivity(intent);
            }
        }
    }

    fun getToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}