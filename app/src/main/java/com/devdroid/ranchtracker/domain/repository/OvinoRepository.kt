package com.devdroid.ranchtracker.domain.repository

import com.devdroid.ranchtracker.domain.model.OvinoItem

interface OvinoRepository {

    suspend fun insertOvino(ovinoItem: OvinoItem): Long

    suspend fun getAllOvinos(): List<OvinoItem>
}