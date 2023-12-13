package com.devdroid.ranchtracker.di

import android.content.Context
import androidx.room.Room
import com.devdroid.ranchtracker.RanchTrackerApp
import com.devdroid.ranchtracker.data.source.local.RanchTrackerDatabase
import com.devdroid.ranchtracker.data.source.local.dao.BovinoDao
import com.devdroid.ranchtracker.data.source.local.dao.OvinoDao
import com.devdroid.ranchtracker.data.source.repository.BovinoRepositoryImpl
import com.devdroid.ranchtracker.data.source.repository.OvinoRepositoryImpl
import com.devdroid.ranchtracker.domain.repository.BovinoRepository
import com.devdroid.ranchtracker.domain.repository.OvinoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "ranchtracker_db"


    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): RanchTrackerDatabase{
        return Room.databaseBuilder(context, RanchTrackerDatabase::class.java, DATABASE_NAME).build()
    }

    //Funciones que proveen los Daos y repoositorios para dagger Hilt

    @Singleton
    @Provides
    fun provideBovinoDao(db: RanchTrackerDatabase): BovinoDao{
        return db.bovinoDao()
    }

    @Singleton
    @Provides
    fun provideBovinoRepository(bovinoDao: BovinoDao): BovinoRepository{
        return BovinoRepositoryImpl(bovinoDao)
    }

    @Singleton
    @Provides
    fun provideOvinoDao(db: RanchTrackerDatabase): OvinoDao {
        return db.ovinoDao()
    }

    @Singleton
    @Provides
    fun provideOvinoRepository(ovinoDao: OvinoDao): OvinoRepository {
        return OvinoRepositoryImpl(ovinoDao)
    }

}