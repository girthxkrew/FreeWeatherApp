package com.rkm.database.datasource.implementation

import com.rkm.database.datasource.abstraction.CurrentWeatherLocalDataSource
import com.rkm.database.doas.CurrentWeatherDao
import com.rkm.database.models.CurrentWeatherEntity
import javax.inject.Inject

internal class CurrentWeatherLocalDataSourceImpl @Inject constructor(
    private val dao: CurrentWeatherDao
): CurrentWeatherLocalDataSource {
    override suspend fun upsertCurrentWeather(currentWeather: CurrentWeatherEntity) {
        dao.upsertCurrentWeather(currentWeather)
    }

    override suspend fun getCurrentWeatherById(id: Int): CurrentWeatherEntity? {
        return dao.getCurrentWeatherById(id)
    }

    override suspend fun getAllCurrentWeather(): List<CurrentWeatherEntity>? {
        return dao.getAllCurrentWeather()
    }

    override suspend fun deleteCurrentWeatherById(id: Int) {
        dao.deleteCurrentWeatherById(id)
    }
}