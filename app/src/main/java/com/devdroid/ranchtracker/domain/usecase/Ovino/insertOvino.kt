package com.devdroid.ranchtracker.domain.usecase.Ovino


import com.devdroid.ranchtracker.domain.model.OvinoItem
import com.devdroid.ranchtracker.domain.repository.OvinoRepository
import javax.inject.Inject

class insertOvino @Inject constructor(private val repository: OvinoRepository) {

    suspend operator fun invoke(ovino: OvinoItem): Long{
        return repository.insertOvino(ovino)
    }
}