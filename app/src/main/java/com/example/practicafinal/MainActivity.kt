package com.example.practicafinal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: UniversityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        adapter = UniversityAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        viewModel.universities.observe(this, Observer { universities ->
            adapter.setData(universities)
        })

        viewModel.fetchData()
    }
}


