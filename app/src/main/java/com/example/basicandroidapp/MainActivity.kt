package com.example.basicandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val validateBtn = findViewById<Button>(R.id.validateButton)
        validateBtn.setOnClickListener {
            onValidate()
        }

        val returnBtn = findViewById<Button>(R.id.returnButton)
        returnBtn.setOnClickListener {
            finish()
        }
    }

    private fun onValidate() {
        val lastname = findViewById<EditText>(R.id.lastnameEditText)
        val firstname = findViewById<EditText>(R.id.firstnameEditText)
        val age = findViewById<EditText>(R.id.ageEditText)
        val domain = findViewById<EditText>(R.id.domainEditText)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberEditText)

        if (lastname.text.trim().toString().isEmpty() || firstname.text.trim().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.name_error), Toast.LENGTH_SHORT).show()
        }
        else if (phoneNumber.text.trim().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.phoneNumber_error), Toast.LENGTH_SHORT).show()
        } else {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle(getString(R.string.title_validation))
            alertDialogBuilder.setMessage(getString(R.string.message_validation))
            alertDialogBuilder.setCancelable(false)

            alertDialogBuilder.setPositiveButton(getString(R.string.alert_yes)) { _, _ ->
                val intent = Intent(this, ConfirmActivity::class.java)

                intent.putExtra("lastname", lastname.text.toString())
                intent.putExtra("firstname", firstname.text.toString())
                intent.putExtra("age", age.text.toString())
                intent.putExtra("domain", domain.text.toString())
                intent.putExtra("phoneNumber", phoneNumber.text.toString())

                startActivity(intent)
            }

            alertDialogBuilder.setNegativeButton(getString(R.string.alert_no)) { _, _ ->
                Toast.makeText(this, getString(R.string.cancelled_validation), Toast.LENGTH_SHORT).show()
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}