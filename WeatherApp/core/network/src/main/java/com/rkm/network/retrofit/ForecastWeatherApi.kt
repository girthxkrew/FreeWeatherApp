package com.rkm.network.retrofit

import com.rkm.network.models.ForecastedWeather.ForecastedWeatherResponse
import com.rkm.network.datasource.ForecastedWeatherRemoteDataSource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

internal object ForecastedWeatherEndPoints{
    const val FORECASTED_WEATHER = "forecast.json"
}
internal interface ForecastedWeatherApi {

    @GET(ForecastedWeatherEndPoints.FORECASTED_WEATHER)
    suspend fun getForecastedWeatherByCity(
        @Query("q") city: String,
        @Query("days") days: Int,
        @Query("aqi") airQuality: String
    ): Response<ForecastedWeatherResponse>

    @GET(ForecastedWeatherEndPoints.FORECASTED_WEATHER)
    suspend fun getForecastedWeatherByCoordinates(
        @Query("q") coordinates: String,
        @Query("days") days: Int,
        @Query("aqi") airQuality: String
    ): Response<ForecastedWeatherResponse>
}

@Singleton
internal class ForecastedWeatherRemoteDataSourceImpl @Inject constructor(
    private val remoteDataSource: ForecastedWeatherApi
): ForecastedWeatherRemoteDataSource {
    override suspend fun getForecastedWeatherByCity(
        city: String,
        airQuality: String,
        days: Int
    ): Response<ForecastedWeatherResponse> {
        return remoteDataSource.getForecastedWeatherByCity(city, days, airQuality)
    }

    override suspend fun getForecastedWeatherByCoordinates(
        coordinates: String,
        airQuality: String,
        days: Int
    ): Response<ForecastedWeatherResponse> {
        return remoteDataSource.getForecastedWeatherByCoordinates(coordinates, days, airQuality)
    }

}