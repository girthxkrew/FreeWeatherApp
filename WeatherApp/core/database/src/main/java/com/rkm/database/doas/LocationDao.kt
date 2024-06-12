package com.rkm.database.doas

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rkm.database.models.LocationEntity

@Dao
internal interface LocationDao {

    @Upsert()
    suspend fun upsertLocation(location: LocationEntity)

    @Query(value = "SELECT * FROM locations")
    suspend fun getAllLocations(): List<LocationEntity>

    @Query(value = "SELECT * FROM locations WHERE id = :id")
    suspend fun getLocationById(id: Int): LocationEntity

    @Query(value = "SELECT * FROM locations WHERE name = :name AND country = :country")
    suspend fun getLocationByNameAndCountry(name: String, country: String): LocationEntity

    @Query(value = "DELETE FROM locations WHERE id = :id")
    suspend fun deleteLocationById(id: Int)
}