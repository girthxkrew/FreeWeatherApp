package com.rkm.database.doas

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rkm.database.models.HourlyForecastEntity

@Dao
internal interface HourlyForecastDao {

    @Upsert
    suspend fun upsertHourlyForecast(hourlyForecast: List<HourlyForecastEntity>)

    @Query("SELECT * FROM hourly_forecast")
    suspend fun getAllHourlyForecast(): List<HourlyForecastEntity>?

    @Query("SELECT * FROM hourly_forecast WHERE location_id = :id")
    suspend fun getHourlyForecastByLocation(id: Int): List<HourlyForecastEntity>?

    @Query("DELETE FROM hourly_forecast WHERE location_id = :id")
    suspend fun deleteHourlyForecastByLocation(id: Int)


}