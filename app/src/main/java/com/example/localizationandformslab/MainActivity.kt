package com.example.localizationandformslab

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val products = resources.getStringArray(R.array.products_array)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Выбрано: ${products[position]}", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}