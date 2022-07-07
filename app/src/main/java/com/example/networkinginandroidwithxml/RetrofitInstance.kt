package com.example.networkinginandroidwithxml

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //What is lazy?
    // A kotlin feature for memory optimization. this creates the specific obj whenever they are needed.
    val api: ToDoAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ToDoAPI::class.java)
    }
}