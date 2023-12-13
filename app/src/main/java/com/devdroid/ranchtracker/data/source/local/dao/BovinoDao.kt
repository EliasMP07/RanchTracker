package com.devdroid.ranchtracker.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity

@Dao
interface BovinoDao {

    @Query("SELECT * FROM bovino_table")
    suspend fun getAllBovinos(): List<BovinoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBovino(bovinoEntity: BovinoEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBovino(bovinoEntity: BovinoEntity)
}