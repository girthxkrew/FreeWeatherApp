package com.rkm.database.doas

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rkm.database.models.ForecastWeatherEntity

@Dao
internal interface ForecastWeatherDao {

    @Upsert
    suspend fun upsertForecastWeather(forecastWeather: ForecastWeatherEntity)

    @Query("SELECT * FROM forecast_weather WHERE location_id = :id")
    suspend fun getForecastWeatherByLocationId(id: Int): ForecastWeatherEntity

    @Query("SELECT * FROM forecast_weather")
    suspend fun getAllForecastWeather(): List<ForecastWeatherEntity>

    @Query("DELETE FROM forecast_weather WHERE location_id = :id")
    suspend fun deleteForecastWeatherByLocationId(id: Int)

}