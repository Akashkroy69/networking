# Networking
# Note From Philip Retro Video

Note from Philipp Video:
Step 1: Add the following dependencies.
// Retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation "com.squareup.okhttp3:okhttp:4.9.0"

// Coroutines
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'

// Coroutine Lifecycle Scopes
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"


What is Retrofit?
→ Retrofit is a networking library for Android and Java which is based on top of HTTP.

Step 2: Add internet permission to the AndroidManifest.xml.
Step 3: Add an interface that holds methods annoted by Retrofit to communicate with the REST API and RESTFUL services.
Step 4: Create a Model class/Data class based on the properties the API holds.

Based on this we have to make a data class. In some cases, a number of parameters can be so many. So we will use one android studio plugin tool for generating a data class: JSON to Kotlin.

Step 5: Create an API interface that can communicate to the API. It holds methods that we will use to GET, and POST information from/in the API.
import retrofit2.Response
import retrofit2.http.GET

interface ToDoAPI {

@GET("/todos")
fun getToDos(): Response<List<Todo>>
}


