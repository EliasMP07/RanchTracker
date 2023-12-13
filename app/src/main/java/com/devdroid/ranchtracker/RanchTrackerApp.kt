package com.devdroid.ranchtracker

import android.app.Application
import android.content.Context
import com.devdroid.ranchtracker.data.source.local.dao.BovinoDao
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RanchTrackerApp: Application() {

    companion object {
        private var instancia: RanchTrackerApp? = null

        fun getAppContext(): Context{
            return instancia!!.applicationContext
        }
    }

    init {
        instancia = this
    }

    override fun onCreate() {
        super.onCreate()

    }

}