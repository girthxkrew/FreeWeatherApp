package com.rkm.network.retrofit

import com.rkm.network.BuildConfig
import com.rkm.network.models.CurrentWeather.CurrentWeatherResponse
import com.rkm.network.repository.CurrentWeatherRemoteDataSource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

internal object CurrentWeatherEndPoints {
    const val CURRENT_WEATHER = "current.json"
}

internal interface CurrentWeatherApi {

    @GET(CurrentWeatherEndPoints.CURRENT_WEATHER)
    suspend fun getCurrentLocationByCity(
        @Query("q") city: String
    ): Response<CurrentWeatherResponse>

    @GET(CurrentWeatherEndPoints.CURRENT_WEATHER)
    suspend fun getCurrentWeatherByCoordinates(
        @Query("q") coordinates: String
    ): Response<CurrentWeatherResponse>
}

@Singleton
internal class CurrentWeatherRemoteDataSourceImpl @Inject constructor(
    private val remoteDataSource: CurrentWeatherApi
): CurrentWeatherRemoteDataSource {
    override suspend fun getCurrentWeatherByCity(city: String): Response<CurrentWeatherResponse> {
        return remoteDataSource.getCurrentLocationByCity(city)
    }

    override suspend fun getCurrentWeatherByCoordinates(coordinates: String): Response<CurrentWeatherResponse> {
        return remoteDataSource.getCurrentWeatherByCoordinates(coordinates)
    }

}
