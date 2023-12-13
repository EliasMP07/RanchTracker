package com.devdroid.ranchtracker.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devdroid.ranchtracker.domain.model.OvinoItem


@Entity(tableName = "ovino_table")
data class OvinoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "numarete") val numArete: Int,
    @ColumnInfo(name = "gendertype") val genderType: String,
    @ColumnInfo(name = "gestationstatus") val gestationStatus: String,
    @ColumnInfo(name ="hascria") val hasCria: Boolean
)

fun OvinoItem.toDatabase() = OvinoEntity(
    id = id,
    numArete = numArete,
    genderType = genderType,
    gestationStatus = gestationStatus,
    hasCria = hasCria
)