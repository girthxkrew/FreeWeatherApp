package com.rkm.database.di

import com.rkm.database.datasource.abstraction.CurrentWeatherLocalDataSource
import com.rkm.database.datasource.abstraction.ForecastWeatherLocalDataSource
import com.rkm.database.datasource.abstraction.HourlyForecastLocalDataSource
import com.rkm.database.datasource.abstraction.LocationLocalDataSource
import com.rkm.database.datasource.implementation.CurrentWeatherLocalDataSourceImpl
import com.rkm.database.datasource.implementation.ForecastWeatherLocalDataSourceImpl
import com.rkm.database.datasource.implementation.HourlyForecastLocalDataSourceImpl
import com.rkm.database.datasource.implementation.LocationLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatabaseDataSourceModule {

    @Singleton
    @Binds
    abstract fun bindsCurrentWeatherLocalDataSource(dataSource: CurrentWeatherLocalDataSourceImpl): CurrentWeatherLocalDataSource

    @Singleton
    @Binds
    abstract fun bindsForecastWeatherLocalDataSource(dataSource: ForecastWeatherLocalDataSourceImpl): ForecastWeatherLocalDataSource

    @Singleton
    @Binds
    abstract fun bindsHourlyForecastLocalDataSource(dataSource: HourlyForecastLocalDataSourceImpl): HourlyForecastLocalDataSource

    @Singleton
    @Binds
    abstract fun bindsLocationLocalDataSource(dataSource: LocationLocalDataSourceImpl): LocationLocalDataSource
}