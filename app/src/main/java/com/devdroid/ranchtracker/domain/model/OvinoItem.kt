package com.devdroid.ranchtracker.domain.model

data class OvinoItem(
    val id: Long,
    val numArete: Int,
    val genderType: String,
    val gestationStatus: String,
    val hasCria: Boolean
)
