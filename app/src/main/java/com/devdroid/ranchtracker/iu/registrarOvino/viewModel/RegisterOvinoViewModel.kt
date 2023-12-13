package com.devdroid.ranchtracker.iu.registrarOvino.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.ranchtracker.domain.model.OvinoItem
import com.devdroid.ranchtracker.domain.usecase.Ovino.insertOvino
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterOvinoViewModel @Inject constructor(

    private val insertOvino: insertOvino
): ViewModel() {

    //Funcion que inserta a la base de datos al Ovino que se le pasa como parametro por la IU y se ejecuta en un hilo secundario
    fun addOvino(ovinoItem: OvinoItem){
        viewModelScope.launch(Dispatchers.IO) {
            insertOvino(ovinoItem)
        }
    }

}