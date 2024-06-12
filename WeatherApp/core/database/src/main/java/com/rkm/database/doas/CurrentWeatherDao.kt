package com.rkm.database.doas

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.rkm.database.models.CurrentWeatherEntity

@Dao
internal interface CurrentWeatherDao {

    @Upsert
    suspend fun upsertCurrentWeather(currentWeather: CurrentWeatherEntity)

    @Query("SELECT * FROM current_weather WHERE location_id = :id")
    suspend fun getCurrentWeatherById(id: Int): CurrentWeatherEntity?

    @Query("SELECT * FROM current_weather")
    suspend fun getAllCurrentWeather(): List<CurrentWeatherEntity>?

    @Query("DELETE FROM current_weather WHERE location_id = :id")
    suspend fun deleteCurrentWeatherById(id: Int)

}