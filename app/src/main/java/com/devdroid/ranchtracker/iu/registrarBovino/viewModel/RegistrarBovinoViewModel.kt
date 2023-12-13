package com.devdroid.ranchtracker.iu.registrarBovino.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.usecase.Bovino.insertBovino
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrarBovinoViewModel @Inject constructor(

    private val insertBovino: insertBovino,
) : ViewModel() {
    fun agregarBovino(bovinoItem: BovinoItem) {



        viewModelScope.launch(Dispatchers.IO) {
            insertBovino(bovinoItem)

        }



    }


}