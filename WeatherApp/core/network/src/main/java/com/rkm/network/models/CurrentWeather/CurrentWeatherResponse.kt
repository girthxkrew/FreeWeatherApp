package com.rkm.network.models.CurrentWeather


import com.google.gson.annotations.SerializedName
import com.rkm.network.models.ForecastedWeather.Current
import com.rkm.network.models.ForecastedWeather.Location

data class CurrentWeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location
)
