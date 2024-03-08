package com.example.basicandroidapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AgendaActivity : AppCompatActivity() {

    private val events = HashMap<String, ArrayList<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val addEventTextView = findViewById<EditText>(R.id.add_events_text_view)
        val calendar = findViewById<CalendarView>(R.id.calendar)
        val eventList = findViewById<ListView>(R.id.list_events)
        val addEventBtn = findViewById<Button>(R.id.add_btn)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        eventList.adapter = adapter

        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(calendar.date))
            val displayEvents = events[selectedDate] ?: ArrayList()
            adapter.clear()
            adapter.addAll(displayEvents)
        }

        addEventBtn.setOnClickListener {
            val eventMessage = addEventTextView.text.toString()
            if (eventMessage.trim().isNotEmpty()) {
                val selectedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(calendar.date))
                val eventList = events.getOrPut(selectedDate) { ArrayList() }
                eventList.add(eventMessage)
                addEventTextView.setText("")
                Toast.makeText(this, getString(R.string.agenda_success), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
