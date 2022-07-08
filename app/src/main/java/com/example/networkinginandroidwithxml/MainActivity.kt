package com.example.networkinginandroidwithxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.networkinginandroidwithxml.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this is first commit in the philipretro branch

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        //setting up RV with its adapter
        val adapterForRV = AdapterForRV()
        activityMainBinding.rvId.adapter = adapterForRV


        //code for the api request.
        //We want to make this request on background thread as this process can take much time
        //so we will use: lifecycleScope.launch{}
        lifecycleScope.launch {

            activityMainBinding.progressBarId.isVisible = true
            val response = try {
                RetrofitInstance.api.getToDos()
            } catch (e: IOException) {
                Log.e(TAG, "onCreate:IOException, You might not have internet connection")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "onCreate: HTTPException, Unexpected response")
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                adapterForRV.todos = response.body()!!
            } else {
                Log.e(TAG, "onCreate: response not successful")
            }
        }


    }
}