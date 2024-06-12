package com.rkm.database.models

import androidx.room.ColumnInfo

data class AirQualityEntity(
    @ColumnInfo(name = "co") val carbonMonoxide: Float,
    @ColumnInfo(name = "no2") val nitrogenDioxide: Float,
    @ColumnInfo(name = "o3") val ozone: Float,
    @ColumnInfo(name = "so2") val sulfurDioxide: Float,
    @ColumnInfo(name = "pm2_5") val particulateMatter2_5: Float,
    @ColumnInfo(name = "pm10") val particulateMatter10: Float,
    @ColumnInfo(name = "us-epa-index") val usEpaIndex: Int,
    @ColumnInfo(name = "gb-defra-index") val gbDefraIndex: Int
)
