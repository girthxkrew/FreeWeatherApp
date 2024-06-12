package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class ForecastDayEntity(
    @ColumnInfo(name = "maxtemp_c") val maxTemperatureCelsius: Double,
    @ColumnInfo(name = "maxtemp_f") val maxTemperatureFahrenheit: Double,
    @ColumnInfo(name = "mintemp_c") val minTemperatureCelsius: Double,
    @ColumnInfo(name = "mintemp_f") val minTemperatureFahrenheit: Double,
    @ColumnInfo(name = "avgtemp_c") val averageTemperatureCelsius: Double,
    @ColumnInfo(name = "avgtemp_f") val averageTemperatureFahrenheit: Double,
    @ColumnInfo(name = "maxwind_mph") val maxWindMph: Double,
    @ColumnInfo(name = "maxwind_kph") val maxWindKph: Double,
    @ColumnInfo(name = "totalprecip_mm") val totalPrecipitationInMillimeters: Double,
    @ColumnInfo(name = "totalprecip_in") val totalPrecipitationInInches: Double,
    @ColumnInfo(name = "totalsnow_cm") val totalSnowInCentimeters: Double,
    @ColumnInfo(name = "avgvis_km") val averageVisibilityInKm: Double,
    @ColumnInfo(name = "avgvis_miles") val averageVisibilityInMiles: Double,
    @ColumnInfo(name = "avghumidity") val averageHumidity: Int,
    @ColumnInfo(name = "daily_will_it_rain") val dailyWillItRain: Boolean,
    @ColumnInfo(name = "daily_chance_of_rain") val dailyChanceOfRain: Int,
    @ColumnInfo(name = "daily_will_it_snow") val dailyWillItSnow: Boolean,
    @ColumnInfo(name = "daily_chance_of_snow") val dailyChanceOfSnow: Int,
    @Embedded val condition: ConditionEntity,
    @ColumnInfo(name = "uv") val uvIndex: Double
)
