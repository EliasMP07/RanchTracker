package com.devdroid.ranchtracker.iu.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}