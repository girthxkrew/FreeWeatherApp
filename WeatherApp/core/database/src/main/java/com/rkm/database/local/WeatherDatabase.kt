package com.rkm.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rkm.database.doas.CurrentWeatherDao
import com.rkm.database.doas.ForecastWeatherDao
import com.rkm.database.doas.HourlyForecastDao
import com.rkm.database.doas.LocationDao
import com.rkm.database.models.AirQualityEntity
import com.rkm.database.models.AstroEntity
import com.rkm.database.models.ConditionEntity
import com.rkm.database.models.CurrentWeatherEntity
import com.rkm.database.models.ForecastDayEntity
import com.rkm.database.models.ForecastWeatherEntity
import com.rkm.database.models.HourlyForecastEntity
import com.rkm.database.models.LocationEntity

@Database(
    entities = [AirQualityEntity::class, AstroEntity::class, ConditionEntity::class,
        CurrentWeatherEntity::class, ForecastWeatherEntity::class, ForecastDayEntity::class,
        HourlyForecastEntity::class, LocationEntity::class],
    version = 1
)
internal abstract class WeatherDatabase: RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao

    abstract fun forecastWeatherDao(): ForecastWeatherDao

    abstract fun hourlyForecastDao(): HourlyForecastDao

    abstract fun locationDao(): LocationDao

}