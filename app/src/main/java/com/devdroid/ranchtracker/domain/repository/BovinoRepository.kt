package com.devdroid.ranchtracker.domain.repository

import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.domain.model.OvinoItem

interface BovinoRepository {

    suspend fun insertBovino(bovinoItem: BovinoItem): Long
    suspend fun getAllBovinos(): List<BovinoItem>
}