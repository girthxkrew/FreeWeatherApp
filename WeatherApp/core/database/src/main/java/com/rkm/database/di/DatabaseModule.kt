package com.rkm.database.di

import android.content.Context
import androidx.room.Room
import com.rkm.database.doas.CurrentWeatherDao
import com.rkm.database.doas.ForecastWeatherDao
import com.rkm.database.doas.HourlyForecastDao
import com.rkm.database.doas.LocationDao
import com.rkm.database.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun providesWeatherDatabase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather_database"
        ).build()
    }

    @Provides
    fun providesCurrentWeatherDao(weatherDatabase: WeatherDatabase): CurrentWeatherDao {
        return weatherDatabase.currentWeatherDao()
    }

    @Provides
    fun providesForecastWeatherDao(weatherDatabase: WeatherDatabase): ForecastWeatherDao {
        return weatherDatabase.forecastWeatherDao()
    }

    @Provides
    fun providesHourlyForecastDao(weatherDatabase: WeatherDatabase): HourlyForecastDao {
        return weatherDatabase.hourlyForecastDao()
    }

    @Provides
    fun providesLocationDao(weatherDatabase: WeatherDatabase): LocationDao {
        return weatherDatabase.locationDao()
    }
}