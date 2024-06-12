package com.rkm.database.datasource.abstraction

import com.rkm.database.models.CurrentWeatherEntity

interface CurrentWeatherLocalDataSource {

    suspend fun upsertCurrentWeather(currentWeather: CurrentWeatherEntity)

    suspend fun getCurrentWeatherById(id: Int): CurrentWeatherEntity?

    suspend fun getAllCurrentWeather(): List<CurrentWeatherEntity>?

    suspend fun deleteCurrentWeatherById(id: Int)
}