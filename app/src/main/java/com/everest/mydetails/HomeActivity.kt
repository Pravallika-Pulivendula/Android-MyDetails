package com.everest.mydetails

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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

        submitData(firstName, age, bio, phoneNumber)
    }

    private fun submitData(
        firstName: EditText,
        age: EditText,
        bio: EditText,
        phoneNumber: EditText
    ) {
        submitButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            if (validator.isInputValid(firstName, age, bio, phoneNumber)) {
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

    fun getToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}