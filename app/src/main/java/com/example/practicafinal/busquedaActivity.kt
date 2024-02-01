package com.example.practicafinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BusquedaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda)

        val spinnerCountries: Spinner = findViewById(R.id.spinner_countries)
        val button: Button = findViewById(R.id.button)

        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this, R.array.countries, android.R.layout.simple_spinner_item
        )


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCountries.adapter = adapter
        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Seleccionado: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button.setOnClickListener {
            val selectedCountry = spinnerCountries.selectedItem.toString()
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("selectedCountry", selectedCountry)
            }
            startActivity(intent)
        }
    }
}
