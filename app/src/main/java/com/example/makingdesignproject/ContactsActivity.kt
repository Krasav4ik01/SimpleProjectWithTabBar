package com.example.makingdesignproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ContactsActivity : AppCompatActivity() {

    val stringList = listOf("apple", "banana", "orange", "pear")
     lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        listView = findViewById(R.id.listView)

        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.name_items, R.id.item_name, stringList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = listView.getItemAtPosition(position) as String
            Toast.makeText(view.context, "You clicked on $selectedItem", Toast.LENGTH_SHORT).show()
            // Code to handle item click event goes here
        }

    }

    fun goHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}