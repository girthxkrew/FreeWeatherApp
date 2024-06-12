package com.rkm.database.datasource.abstraction

import androidx.room.Query
import com.rkm.database.models.LocationEntity

interface LocationLocalDataSource {

    suspend fun upsertLocation(location: LocationEntity)

    suspend fun getAllLocations(): List<LocationEntity>?

    suspend fun getLocationById(id: Int): LocationEntity?

    suspend fun getLocationByNameAndCountry(name: String, country: String): LocationEntity?

    suspend fun deleteLocationById(id: Int)

}