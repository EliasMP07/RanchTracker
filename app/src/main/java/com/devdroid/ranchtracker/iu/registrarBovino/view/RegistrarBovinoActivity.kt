package com.devdroid.ranchtracker.iu.registrarBovino.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.devdroid.ranchtracker.databinding.ActivityRegistrarBovinoBinding
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.iu.bovino.viewModel.BovinoViewModel
import com.devdroid.ranchtracker.iu.registrarBovino.viewModel.RegistrarBovinoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrarBovinoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBovinoBinding
    private val viewModel : RegistrarBovinoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBovinoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAgregarBovino.setOnClickListener {



            viewModel.agregarBovino(
                    BovinoItem().apply {
                        id = 0
                        numArete = "32323"
                        genderType = "Masculino"
                        peso = 33.0
                        año = 2012
                        categoryType = "trtr"


                    })



        binding.btnBack.setOnClickListener {

            onBackPressedDispatcher.onBackPressed()
        }


        }
    }
}