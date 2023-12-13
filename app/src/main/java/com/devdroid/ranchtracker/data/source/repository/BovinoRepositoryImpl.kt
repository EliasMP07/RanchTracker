package com.devdroid.ranchtracker.data.source.repository

import com.devdroid.ranchtracker.data.source.local.dao.BovinoDao
import com.devdroid.ranchtracker.data.source.local.entities.toDatabase
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.model.toDomain
import com.devdroid.ranchtracker.domain.repository.BovinoRepository
import javax.inject.Inject

class BovinoRepositoryImpl @Inject constructor(
    private val bovinoDao: BovinoDao
): BovinoRepository {
    override suspend fun insertBovino(bovinoItem: BovinoItem): Long {
        return  bovinoDao.insertBovino(bovinoItem.toDatabase())
    }

    override suspend fun getAllBovinos(): List<BovinoItem> {
        val response = bovinoDao.getAllBovinos()
        return response.map {
            it.toDomain()
        }
    }

}