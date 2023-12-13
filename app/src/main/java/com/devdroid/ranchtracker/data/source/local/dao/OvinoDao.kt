package com.devdroid.ranchtracker.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devdroid.ranchtracker.data.source.local.entities.OvinoEntity

@Dao
interface OvinoDao {
    @Query("SELECT * FROM ovino_table")
    suspend fun getAllOvinos():List<OvinoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOvino(ovinoEntity: OvinoEntity):Long


}