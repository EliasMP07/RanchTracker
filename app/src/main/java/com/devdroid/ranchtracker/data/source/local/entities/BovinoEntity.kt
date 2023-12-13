package com.devdroid.ranchtracker.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devdroid.ranchtracker.domain.model.BovinoItem


@Entity(tableName = "bovino_table")
data class BovinoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long = 0,
    @ColumnInfo(name = "numarete") var numArete: String = "",
    @ColumnInfo(name = "gendertipe") var genderType: String = "",
    @ColumnInfo(name = "peso" )var peso: Double =  0.0,
    @ColumnInfo(name = "año") var año: Int = 0,
    @ColumnInfo(name = "categorytype") var categoryType: String = ""
)

fun BovinoItem.toDatabase() = BovinoEntity(
    id = id,
    numArete = numArete,
    genderType = genderType,
    peso = peso,
    año = año,
    categoryType = categoryType
)