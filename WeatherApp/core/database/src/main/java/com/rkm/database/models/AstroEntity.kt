package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "astro",
    foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["location_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class AstroEntity(
    @PrimaryKey
    @ColumnInfo(name = "location_id") val locationId: Int = 0,
    @ColumnInfo(name = "sunrise") val sunrise: String,
    @ColumnInfo(name = "sunset") val sunset: String,
    @ColumnInfo(name = "moonrise") val moonrise: String,
    @ColumnInfo(name = "moonset") val moonset: String,
    @ColumnInfo(name = "moon_phase") val moonPhase: String,
    @ColumnInfo(name = "moon_illumination") val moonIllumination: Int,
    @ColumnInfo(name = "is_moon_up") val isMoonUp: Boolean,
    @ColumnInfo(name = "is_sun_up") val isSunUp: Boolean
)