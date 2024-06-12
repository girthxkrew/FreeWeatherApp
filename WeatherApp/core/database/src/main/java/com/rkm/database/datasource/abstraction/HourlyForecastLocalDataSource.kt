package com.rkm.database.datasource.abstraction

import androidx.room.Query
import com.rkm.database.models.HourlyForecastEntity

interface HourlyForecastLocalDataSource {

    suspend fun upsertHourlyForecast(list: List<HourlyForecastEntity>)

    suspend fun getAllHourlyForecast(): List<HourlyForecastEntity>?

    suspend fun getHourlyForecastByLocation(id: Int): List<HourlyForecastEntity>?

    suspend fun deleteHourlyForecastByLocation(id: Int)
}