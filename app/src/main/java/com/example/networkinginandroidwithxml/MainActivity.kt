package com.example.networkinginandroidwithxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networkinginandroidwithxml.databinding.ActivityMainBinding

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



    }
}