package com.devdroid.ranchtracker.domain.usecase.Bovino

import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.repository.BovinoRepository
import javax.inject.Inject

class insertBovino @Inject constructor(private val repository: BovinoRepository) {

    suspend operator fun invoke(bovino: BovinoItem): Long{
         return repository.insertBovino(bovino)
    }
}