package com.rkm.database.datasource.implementation

import com.rkm.database.datasource.abstraction.HourlyForecastLocalDataSource
import com.rkm.database.doas.HourlyForecastDao
import com.rkm.database.models.HourlyForecastEntity
import javax.inject.Inject

internal class HourlyForecastLocalDataSourceImpl @Inject constructor(
    private val dao: HourlyForecastDao
): HourlyForecastLocalDataSource {
    override suspend fun upsertHourlyForecast(list: List<HourlyForecastEntity>) {
        dao.upsertHourlyForecast(list)
    }

    override suspend fun getAllHourlyForecast(): List<HourlyForecastEntity>? {
        return dao.getAllHourlyForecast()
    }

    override suspend fun getHourlyForecastByLocation(id: Int): List<HourlyForecastEntity>? {
        return dao.getHourlyForecastByLocation(id)
    }

    override suspend fun deleteHourlyForecastByLocation(id: Int) {
        dao.deleteHourlyForecastByLocation(id)
    }
}