package com.example.basicandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val lastnameTextView = findViewById<TextView>(R.id.lastname_field)
        val firstnameTextView = findViewById<TextView>(R.id.firstname_field)
        val ageTextView = findViewById<TextView>(R.id.age_field)
        val domainTextView = findViewById<TextView>(R.id.domain_field)
        val phoneNumberTextView = findViewById<TextView>(R.id.phoneNumber_field)
        val confirmButton = findViewById<Button>(R.id.ok_button)
        val returnButton = findViewById<Button>(R.id.back_button)

        // Récupération des données saisies depuis l'incent explicite
        val lastname = intent.getStringExtra("lastname")
        val firstname = intent.getStringExtra("firstname")
        val age = intent.getStringExtra("age")
        val domain = intent.getStringExtra("domain")
        val phoneNumber = intent.getStringExtra("phoneNumber")

        // Affichage des données saisies dans les TextView
        lastnameTextView.text = getString(R.string.label_lastname) + " $lastname"
        firstnameTextView.text = getString(R.string.label_firstname) +" $firstname"
        ageTextView.text = getString(R.string.label_age) +" $age"
        domainTextView.text = getString(R.string.label_domain) +" $domain"
        phoneNumberTextView.text = getString(R.string.label_phoneNumber) +" $phoneNumber"

        // Gestion du bouton OK pour lancer l'intent implicite : Appel téléphonique
        confirmButton.setOnClickListener {
            val intentOnCall = Intent(this, CallActivity::class.java)
            intentOnCall.putExtra("phoneNumber", phoneNumber)
            startActivity(intentOnCall)
        }

        // Gestion du bouton Retour pour revenir à l'activité précédente
        returnButton.setOnClickListener {
            finish()
        }
    }
}