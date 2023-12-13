package com.devdroid.ranchtracker.domain.model

import com.devdroid.ranchtracker.data.source.local.entities.OvinoEntity

data class OvinoItem(
    val id: Long,
    val numArete: Int,
    val genderType: String,
    val gestationStatus: String,
    val hasCria: Boolean
)

fun OvinoEntity.toDomain() = OvinoItem(
    id = id,
    numArete = numArete,
    genderType = genderType,
    gestationStatus = gestationStatus,
    hasCria = hasCria
)
