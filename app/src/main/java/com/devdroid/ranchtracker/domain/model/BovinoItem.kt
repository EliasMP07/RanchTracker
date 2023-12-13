package com.devdroid.ranchtracker.domain.model

import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity

data class BovinoItem(
    var id: Long = 0L,
    var numArete: String = "",
    var genderType: String = "",
    var peso: Double = 0.0,
    var año: Int = 0,
    var categoryType: String = ""
)

fun BovinoEntity.toDomain() = BovinoItem(
    id = id,
    numArete = numArete,
    genderType = genderType,
    peso = peso,
    año = año,
    categoryType = categoryType
)