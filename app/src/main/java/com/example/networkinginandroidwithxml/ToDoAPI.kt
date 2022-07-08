package com.example.networkinginandroidwithxml

import retrofit2.Response
import retrofit2.http.GET

interface ToDoAPI {

    @GET("/todos")
    suspend fun getToDos(): Response<List<Todo>>
}