package com.devdroid.ranchtracker.iu.registrarOvino.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.databinding.ActivityRegisterOvinoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterOvinoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterOvinoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterOvinoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}