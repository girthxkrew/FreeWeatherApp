package com.rkm.network.di

import com.rkm.network.repository.CurrentWeatherRemoteDataSource
import com.rkm.network.repository.ForecastedWeatherRemoteDataSource
import com.rkm.network.retrofit.CurrentWeatherRemoteDataSourceImpl
import com.rkm.network.retrofit.ForecastedWeatherRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkDataSourceModule {

    @Binds
    fun bindsCurrentWeatherRemoteDataSource(dataSource: CurrentWeatherRemoteDataSourceImpl): CurrentWeatherRemoteDataSource


    @Binds
    fun bindsForecastedWeatherRemoteDataSource(dataSource: ForecastedWeatherRemoteDataSourceImpl): ForecastedWeatherRemoteDataSource
}