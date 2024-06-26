package com.rkm.network.models.ForecastedWeather


import com.google.gson.annotations.SerializedName

data class ForecastedWeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast,
    @SerializedName("location")
    val location: Location
)