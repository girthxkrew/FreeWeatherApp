package com.rkm.database.datasource.implementation

import com.rkm.database.datasource.abstraction.LocationLocalDataSource
import com.rkm.database.doas.LocationDao
import com.rkm.database.models.LocationEntity
import javax.inject.Inject

internal class LocationLocalDataSourceImpl @Inject constructor(
    private val dao: LocationDao
): LocationLocalDataSource {
    override suspend fun upsertLocation(location: LocationEntity) {
        dao.upsertLocation(location)
    }

    override suspend fun getAllLocations(): List<LocationEntity>? {
        return dao.getAllLocations()
    }

    override suspend fun getLocationById(id: Int): LocationEntity? {
        return dao.getLocationById(id)
    }

    override suspend fun getLocationByNameAndCountry(
        name: String,
        country: String
    ): LocationEntity? {
        return dao.getLocationByNameAndCountry(name, country)
    }

    override suspend fun deleteLocationById(id: Int) {
        dao.deleteLocationById(id)
    }
}