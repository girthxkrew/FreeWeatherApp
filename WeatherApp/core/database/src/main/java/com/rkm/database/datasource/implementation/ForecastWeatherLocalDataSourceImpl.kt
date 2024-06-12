package com.rkm.database.datasource.implementation

import com.rkm.database.datasource.abstraction.ForecastWeatherLocalDataSource
import com.rkm.database.doas.ForecastWeatherDao
import com.rkm.database.models.ForecastWeatherEntity
import javax.inject.Inject

internal class ForecastWeatherLocalDataSourceImpl @Inject constructor(
    private val dao: ForecastWeatherDao
): ForecastWeatherLocalDataSource {
    override suspend fun upsertForecastWeather(forecastWeather: ForecastWeatherEntity) {
        dao.getAllForecastWeather()
    }

    override suspend fun getForecastWeatherByLocationId(id: Int): ForecastWeatherEntity? {
        return dao.getForecastWeatherByLocationId(id)
    }

    override suspend fun getAllForecastWeather(): List<ForecastWeatherEntity>? {
        return dao.getAllForecastWeather()
    }

    override suspend fun deleteForecastWeatherByLocationId(id: Int) {
        dao.deleteForecastWeatherByLocationId(id)
    }

}