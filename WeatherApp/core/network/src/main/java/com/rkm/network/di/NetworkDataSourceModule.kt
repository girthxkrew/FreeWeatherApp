package com.rkm.network.di

import com.rkm.network.datasource.CurrentWeatherRemoteDataSource
import com.rkm.network.datasource.ForecastedWeatherRemoteDataSource
import com.rkm.network.retrofit.CurrentWeatherRemoteDataSourceImpl
import com.rkm.network.retrofit.ForecastedWeatherRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkDataSourceModule {

    @Singleton
    @Binds
    fun bindsCurrentWeatherRemoteDataSource(dataSource: CurrentWeatherRemoteDataSourceImpl): CurrentWeatherRemoteDataSource

    @Singleton
    @Binds
    fun bindsForecastedWeatherRemoteDataSource(dataSource: ForecastedWeatherRemoteDataSourceImpl): ForecastedWeatherRemoteDataSource
}