package com.example.basicandroidapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val callButton: Button = findViewById(R.id.call_btn)
        callButton.setOnClickListener {
            callFunc(it)
        }

        val trainButton: Button = findViewById(R.id.train_btn)
        trainButton.setOnClickListener {
            trainScheduleFunc(it)
        }

        val agendaButton: Button = findViewById(R.id.agenda_btn)
        agendaButton.setOnClickListener {
            agendaFunc(it)
        }
    }

    private fun callFunc(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun trainScheduleFunc(view: View) {
        val i = Intent(this, TrainScheduleActivity::class.java)
        startActivity(i)
    }

    private fun agendaFunc(view: View) {
        val i = Intent(this, CallActivity::class.java)
        startActivity(i)
    }
}