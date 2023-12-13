package com.devdroid.ranchtracker.data.source.repository

import com.devdroid.ranchtracker.data.source.local.dao.OvinoDao
import com.devdroid.ranchtracker.data.source.local.entities.toDatabase
import com.devdroid.ranchtracker.domain.model.OvinoItem
import com.devdroid.ranchtracker.domain.model.toDomain
import com.devdroid.ranchtracker.domain.repository.OvinoRepository
import javax.inject.Inject

class OvinoRepositoryImpl @Inject constructor(
    private val ovinoDao: OvinoDao
) : OvinoRepository {
    override suspend fun insertOvino(ovinoItem: OvinoItem): Long {
        return ovinoDao.insertOvino(ovinoItem.toDatabase())
    }

    override suspend fun getAllOvinos(): List<OvinoItem> {
        val reponse = ovinoDao.getAllOvinos()
        return reponse.map {
            it.toDomain()
        }
    }
}