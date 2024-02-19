package com.example.basicandroidapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        val intent = intent
        val phoneNumber = findViewById<TextView>(R.id.phoneNumberTextView)
        phoneNumber.text = intent.getStringExtra("phoneNumber")
        val backButton = findViewById<Button>(R.id.returnButton)
        backButton.setOnClickListener {
            backFunc(it)
        }
        val callButton = findViewById<Button>(R.id.callButton)
        callButton.setOnClickListener {
            var callIntent: Intent? = null
            callIntent = if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED
            ) {
                Intent(Intent.ACTION_CALL)
            } else {
                Intent(Intent.ACTION_DIAL)
            }
            callIntent.data = Uri.parse("tel:" + phoneNumber.text.toString())
            startActivity(callIntent)
        }
    }

    private fun backFunc(view: View) {
        finish()
    }
}
