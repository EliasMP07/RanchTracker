package com.devdroid.ranchtracker.data.local.database.entities

data class OvinoEntity(
    val id: Long,
    val numArete: Int,
    val genderType: String,
    val gestationStatus: String,
    val hasCria: Boolean
)
