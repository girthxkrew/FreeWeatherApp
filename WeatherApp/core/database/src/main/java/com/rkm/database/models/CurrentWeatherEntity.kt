package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "current_weather",
    foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["location_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CurrentWeatherEntity(
    @PrimaryKey
    @ColumnInfo(name = "location_id") val locationId: Int,
    @ColumnInfo(name = "last_updated_epoch") val lastUpdatedEpoch: Long,
    @ColumnInfo(name = "last_updated") val lastUpdated: String,
    @ColumnInfo(name = "temp_c") val tempCelsius: Double,
    @ColumnInfo(name = "temp_f") val tempFahrenheit: Double,
    @ColumnInfo(name = "is_day") val isDay: Boolean,
    @Embedded val condition: ConditionEntity,
    @ColumnInfo(name = "wind_mph") val windMph: Double,
    @ColumnInfo(name = "wind_kph") val windKph: Double,
    @ColumnInfo(name = "wind_degree") val windDegree: Int,
    @ColumnInfo(name = "wind_dir") val windDirection: String,
    @ColumnInfo(name = "pressure_mb") val pressureInMillibars: Double,
    @ColumnInfo(name = "pressure_in") val pressureInInches: Double,
    @ColumnInfo(name = "precip_mm") val precipitationInMillimeters: Double,
    @ColumnInfo(name = "precip_in") val precipitationInInches: Double,
    @ColumnInfo(name = "humidity") val humidity: Int,
    @ColumnInfo(name = "cloud") val cloud: Int,
    @ColumnInfo(name = "feelslike_c") val feelsLikeCelsius: Double,
    @ColumnInfo(name = "feelslike_f") val feelsLikeFahrenheit: Double,
    @ColumnInfo(name = "windchill_c") val windChillCelsius: Double,
    @ColumnInfo(name = "windchill_f") val windChillFahrenheit: Double,
    @ColumnInfo(name = "heatindex_c") val heatIndexCelsius: Double,
    @ColumnInfo(name = "heatindex_f") val heatIndexFahrenheit: Double,
    @ColumnInfo(name = "dewpoint_c") val dewPointCelsius: Double,
    @ColumnInfo(name = "dewpoint_f") val dewPointFahrenheit: Double,
    @ColumnInfo(name = "vis_miles") val visibilityInMiles: Double,
    @ColumnInfo(name = "vis_km") val visibilityInKilometers: Double,
    @ColumnInfo(name = "uv") val uvIndex: Int,
    @ColumnInfo(name = "gust_mph") val gustMph: Double,
    @ColumnInfo(name = "gust_kph") val gustKph: Double,
    @ColumnInfo(name = "air_quality")
    @Embedded val airQuality: AirQualityEntity

)
