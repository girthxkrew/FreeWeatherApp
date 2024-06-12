package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "air_quality",
    foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["location_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class AirQualityEntity(
    @PrimaryKey
    @ColumnInfo(name = "location_id") val locationId: Int,
    @ColumnInfo(name = "co") val carbonMonoxide: Float,
    @ColumnInfo(name = "no2") val nitrogenDioxide: Float,
    @ColumnInfo(name = "o3") val ozone: Float,
    @ColumnInfo(name = "so2") val sulfurDioxide: Float,
    @ColumnInfo(name = "pm2_5") val particulateMatter2_5: Float,
    @ColumnInfo(name = "pm10") val particulateMatter10: Float,
    @ColumnInfo(name = "us-epa-index") val usEpaIndex: Int,
    @ColumnInfo(name = "gb-defra-index") val gbDefraIndex: Int
)
