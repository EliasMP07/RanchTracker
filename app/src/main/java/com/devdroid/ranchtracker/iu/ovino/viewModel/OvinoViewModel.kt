package com.devdroid.ranchtracker.iu.ovino.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.model.OvinoItem
import com.devdroid.ranchtracker.domain.usecase.Ovino.getAllOvinos
import com.devdroid.ranchtracker.iu.utils.ResponseStatus
import com.devdroid.ranchtracker.iu.utils.makeCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class OvinoViewModel @Inject constructor(

    private val getAllOvinos: getAllOvinos
) : ViewModel(){


    private val _ovino = MutableLiveData<List<OvinoItem>?>()
    val ovino : LiveData<List<OvinoItem>?> = _ovino


    private val _stateList = MutableLiveData<ResponseStatus<List<OvinoItem>>>()
    val stateList: LiveData<ResponseStatus<List<OvinoItem>>> = _stateList


    private fun handleStateList(responseStatus: ResponseStatus<List<OvinoItem>>) {
        if (responseStatus is ResponseStatus.Success)
            _ovino.value = responseStatus.data

        _stateList.value = responseStatus
    }


    fun listarOvinos() {
        viewModelScope.launch {
            _stateList.value = ResponseStatus.Loading()

            handleStateList(
                makeCall {getAllOvinos.invoke()}
            )
        }
    }
}