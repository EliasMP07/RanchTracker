package com.devdroid.ranchtracker.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devdroid.ranchtracker.data.source.local.dao.BovinoDao
import com.devdroid.ranchtracker.data.source.local.dao.OvinoDao
import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity
import com.devdroid.ranchtracker.data.source.local.entities.OvinoEntity

@Database(
    entities =
        [
            BovinoEntity::class,
            OvinoEntity::class
        ],
    version = 1,
    exportSchema = false
)
abstract class RanchTrackerDatabase : RoomDatabase() {
    abstract fun bovinoDao(): BovinoDao
    abstract fun ovinoDao(): OvinoDao
}