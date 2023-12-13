package com.devdroid.ranchtracker.iu.bovino.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.usecase.Bovino.getAllBovinos
import com.devdroid.ranchtracker.domain.usecase.Bovino.insertBovino
import com.devdroid.ranchtracker.iu.bovino.view.adapter.BovinoAdapter
import com.devdroid.ranchtracker.iu.utils.ResponseStatus
import com.devdroid.ranchtracker.iu.utils.makeCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BovinoViewModel @Inject constructor(
    private val getAllBovino: getAllBovinos

) : ViewModel() {



    private val _bovinos = MutableLiveData<List<BovinoItem>?>()
    val bovinos: LiveData<List<BovinoItem>?>  = _bovinos

    private val _stateList = MutableLiveData<ResponseStatus<List<BovinoItem>>>()
    val stateList: LiveData<ResponseStatus<List<BovinoItem>>> = _stateList


    private fun handleStateList(responseStatus: ResponseStatus<List<BovinoItem>>) {
        if (responseStatus is ResponseStatus.Success)
            _bovinos.value = responseStatus.data

        _stateList.value = responseStatus
    }


    fun listar() {
        viewModelScope.launch {
            _stateList.value = ResponseStatus.Loading()

            handleStateList(
                makeCall {getAllBovino.invoke()}
            )
        }
    }





}