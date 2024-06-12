package com.rkm.network.repository

import com.rkm.network.models.ForecastedWeather.ForecastedWeatherResponse
import retrofit2.Response

interface ForecastedWeatherRemoteDataSource {

    suspend fun getForecastedWeatherByCity(
        city: String,
        airQuality: String,
        days: Int
    ): Response<ForecastedWeatherResponse>

    suspend fun getForecastedWeatherByCoordinates(
        coordinates: String,
        airQuality: String,
        days: Int
    ): Response<ForecastedWeatherResponse>

}