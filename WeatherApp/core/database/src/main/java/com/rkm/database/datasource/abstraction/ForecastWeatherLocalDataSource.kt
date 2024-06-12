package com.rkm.database.datasource.abstraction

import com.rkm.database.models.ForecastWeatherEntity

interface ForecastWeatherLocalDataSource {

    suspend fun upsertForecastWeather(forecastWeather: ForecastWeatherEntity)

    suspend fun getForecastWeatherByLocationId(id: Int): ForecastWeatherEntity?

    suspend fun getAllForecastWeather(): List<ForecastWeatherEntity>?

    suspend fun deleteForecastWeatherByLocationId(id: Int)
}