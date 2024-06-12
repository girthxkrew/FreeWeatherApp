package com.rkm.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey val id: Int = 0,
    val name: String,
    val region: String,
    val country: String,
    @ColumnInfo(name = "lat") val latitude: Double,
    @ColumnInfo(name = "lon") val longitude: Double
)
