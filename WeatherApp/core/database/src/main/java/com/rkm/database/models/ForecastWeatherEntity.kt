package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "forecast_weather", foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["location_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ForecastWeatherEntity(
    @PrimaryKey @ColumnInfo(name = "location_id") val locationId: Int,
    val date: String,
    @ColumnInfo(name = "date_epoch") val dateEpoch: Long,
    @Embedded val day: ForecastDayEntity,
    @Embedded val astro: AstroEntity
)
