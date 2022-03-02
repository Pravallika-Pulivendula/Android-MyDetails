package com.everest.mydetails

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

        val colorDrawable = ColorDrawable(Color.parseColor("#0F9D58"))
        supportActionBar?.setBackgroundDrawable(colorDrawable)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val firstName = findViewById<EditText>(R.id.firstNameET)
        val age = findViewById<EditText>(R.id.ageET)
        val bio = findViewById<EditText>(R.id.bioET)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberET)

        submitButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            if (isInputValid(firstName, age, bio, phoneNumber)) {
                intent.putExtra(FIRST_NAME, firstName.text.toString())
                intent.putExtra(AGE, age.text.toString())
                intent.putExtra(BIO, bio.text.toString())
                intent.putExtra(PHONENUMBER, phoneNumber.text.toString())
                startActivity(intent);
            }
        }
    }

    private fun isInputValid(
        firstName: EditText,
        age: EditText,
        bio: EditText,
        phoneNumber: EditText
    ): Boolean {
        when {
            TextUtils.isEmpty(firstName.text) or TextUtils.isEmpty(age.text) or TextUtils.isEmpty(
                bio.text
            ) or TextUtils.isEmpty(phoneNumber.text) -> {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                return false
            }
            Integer.parseInt(age.text.toString()) > 120 -> {
                Toast.makeText(
                    this,
                    "Not a valid age. Max limit - 120",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }
            phoneNumber.length() < 10 -> {
                Toast.makeText(
                    this,
                    "Phone Number should contain 10 digits",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }

        }
        return true
    }
}