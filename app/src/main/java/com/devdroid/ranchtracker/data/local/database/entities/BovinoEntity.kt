package com.devdroid.ranchtracker.data.local.database.entities

data class BovinoEntity(
    val id: Long,
    val numArete: String,
    val optionSex: String,
    val peso: Int,
    val año: Int,
    val optionTipo: String
)
