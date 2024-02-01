package com.example.practicafinal

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _universities = MutableLiveData<List<University>>()
    val universities: LiveData<List<University>> get() = _universities

    // Modifica fetchData para aceptar un parámetro String para el país
    fun fetchData(country: String) {
        viewModelScope.launch {
            try {

                val url = "${ApiService.BASE_URL}search?country=${country.replace(" ", "%20")}"

                Log.d("MyApp", "Request URL: $url")

                val universities = withContext(Dispatchers.IO) {
                    ApiService.instance.getUniversities(country)
                }

                if (universities.isNotEmpty()) {
                    _universities.postValue(universities)
                    Log.d("MyApp", "Data loaded successfully: $universities")
                } else {
                    Log.e("MyApp", "Empty response or unexpected format")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("MyApp", "Error loading data: ${e.message}")
            }
        }
    }
}

