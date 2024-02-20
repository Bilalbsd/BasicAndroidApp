package com.example.basicandroidapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class TrainScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_schedule)

        val backButton = findViewById<Button>(R.id.returnButton)
        backButton.setOnClickListener {
            finish()
        }

        val trainList = findViewById<ListView>(R.id.train_list)
        val searchButton = findViewById<Button>(R.id.search)
        val departure = findViewById<EditText>(R.id.departure)
        val arrival = findViewById<EditText>(R.id.arrival)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        trainList.adapter = adapter

        searchButton.setOnClickListener {
            adapter.clear()
            val dep = departure.text.toString()
            val arr = arrival.text.toString()
            val fixedTimes = arrayOf("08:00", "10:30", "13:45", "16:20", "19:00")
            fixedTimes.forEach { time ->
                adapter.add("$dep - $arr : $time")
            }
            adapter.notifyDataSetChanged()
        }

        // Ajout de l'événement de clic sur un élément de la liste
        trainList.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            if (selectedItem != null && selectedItem != "No result") {
                val dep = departure.text.toString()
                val arr = arrival.text.toString()
                val url = "https://www.sncf-connect.com/train/trajet/$dep/$arr"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }
}
