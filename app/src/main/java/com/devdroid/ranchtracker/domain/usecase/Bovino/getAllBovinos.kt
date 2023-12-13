package com.devdroid.ranchtracker.domain.usecase.Bovino

import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.repository.BovinoRepository
import javax.inject.Inject

class getAllBovinos @Inject constructor( val repository: BovinoRepository) {

    suspend operator fun invoke(): List<BovinoItem> {
        return repository.getAllBovinos()
    }
}