package com.example.workoutapp.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://yourapi.com") // Replace with your server URL
        .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter
        .build()

    val instance: ApiService by lazy {
        retrofit.create(ApiService::class.java) // Create the ApiService instance
    }
}
