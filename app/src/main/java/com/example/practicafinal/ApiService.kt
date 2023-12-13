package com.example.practicafinal

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {
    companion object {
        const val BASE_URL = "http://universities.hipolabs.com/"

        val instance: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ApiService::class.java)
        }
    }

    @GET("search")
    suspend fun getUniversities(@Query("country") country: String): List<University>
}
