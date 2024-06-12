package com.rkm.network.repository

import com.rkm.network.models.CurrentWeather.CurrentWeatherResponse
import retrofit2.Response

interface CurrentWeatherRemoteDataSource {

    suspend fun getCurrentWeatherByCity(city: String): Response<CurrentWeatherResponse>

    suspend fun getCurrentWeatherByCoordinates(coordinates: String): Response<CurrentWeatherResponse>

}