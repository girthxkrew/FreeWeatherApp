package com.rkm.database.models

import androidx.room.ColumnInfo

data class AstroEntity(
    @ColumnInfo(name = "sunrise") val sunrise: String,
    @ColumnInfo(name = "sunset") val sunset: String,
    @ColumnInfo(name = "moonrise") val moonrise: String,
    @ColumnInfo(name = "moonset") val moonset: String,
    @ColumnInfo(name = "moon_phase") val moonPhase: String,
    @ColumnInfo(name = "moon_illumination") val moonIllumination: Int,
    @ColumnInfo(name = "is_moon_up") val isMoonUp: Boolean,
    @ColumnInfo(name = "is_sun_up") val isSunUp: Boolean
)