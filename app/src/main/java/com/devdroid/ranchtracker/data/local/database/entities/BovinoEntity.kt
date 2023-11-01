package com.devdroid.ranchtracker.data.local.database.entities

data class BovinoEntity(
    val id: Long,
    val numArete: String,
    val genderType: String,
    val peso: Double,
    val año: Int,
    val categoryType: String
)
