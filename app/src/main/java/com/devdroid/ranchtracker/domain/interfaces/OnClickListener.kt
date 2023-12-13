package com.devdroid.ranchtracker.domain.interfaces

import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity

interface OnClickListener {
    fun onClick(bovinoEntity: BovinoEntity)

}