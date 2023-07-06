package com.xxmrk888ytxx.database.dataSources

import com.xxmrk888ytxx.database.dao.PlaceDao
import com.xxmrk888ytxx.database.entity.PlaceEntity
import com.xxmrk888ytxx.database.models.PlaceLocalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class PlaceLocalDataSourceImpl(
    private val placeDao: PlaceDao
) : PlaceLocalDataSource {
    override val placesFlow: Flow<List<PlaceLocalModel>> = placeDao.placesFlow.map { list ->
        list.map { it.toLocalModel() }
    }

    override suspend fun insert(placeEntity: PlaceLocalModel) = withContext(Dispatchers.IO) {
        placeDao.insert(placeEntity.toEntity())
    }

    override fun getPlaceById(id: String): Flow<PlaceLocalModel> {
        return placeDao.getPlaceById(id).map { it.toLocalModel() }
    }

    override suspend fun dropData() = withContext(Dispatchers.IO) {
        placeDao.dropData()
    }

    private fun PlaceEntity.toLocalModel() : PlaceLocalModel {
        return PlaceLocalModel(fourSquareId, placeName, placeAddress)
    }

    private fun PlaceLocalModel.toEntity() : PlaceEntity {
        return PlaceEntity(fourSquareId, placeName, placeAddress)
    }
}