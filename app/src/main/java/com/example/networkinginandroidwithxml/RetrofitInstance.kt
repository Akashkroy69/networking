package com.example.networkinginandroidwithxml

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//This is a singleton class (also called singleton object in kotlin).
//What is singleton class/object in kotlin?
//Singleton Class in Kotlin is also called as the Singleton Object in Kotlin.
// Singleton class is a class that is defined in such a way that only one instance of the class can be created and used
// everywhere
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