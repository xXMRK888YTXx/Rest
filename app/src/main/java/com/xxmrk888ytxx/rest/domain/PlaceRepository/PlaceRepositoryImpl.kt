package com.xxmrk888ytxx.rest.domain.PlaceRepository

import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource
import com.xxmrk888ytxx.database.models.PlaceLocalModel
import com.xxmrk888ytxx.placeapi.PlaceRemoteDataSource
import com.xxmrk888ytxx.placeapi.models.PlaceRemoteModel
import com.xxmrk888ytxx.rest.domain.TokenHolder.TokenHolder
import com.xxmrk888ytxx.rest.domain.models.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val placeLocalDataSource: PlaceLocalDataSource,
    private val placeRemoteDataSource: PlaceRemoteDataSource,
    private val tokenHolder: TokenHolder
) : PlaceRepository {
    override val places: Flow<List<Place>> = placeLocalDataSource.placesFlow.map { list ->
        list.map { it.toPlace() }
    }

    override fun getPlaceById(id: String): Flow<Place> {
        return placeLocalDataSource.getPlaceById(id).map {
            it.toPlace()
        }
    }

    override suspend fun dropCached() {
        placeLocalDataSource.dropData()
    }

    override suspend fun load() {
        val token = tokenHolder.tokenFlow.first() ?: throw TokenNotSetup()

        val places = placeRemoteDataSource.getPlaces(token)

        places.forEach {
            placeLocalDataSource.insert(it.toLocalModel())
        }
    }


    private fun Place.toLocalSourceModule() : PlaceLocalModel {
        return PlaceLocalModel(fourSquareId, placeName, placeAddress)
    }

    private fun PlaceLocalModel.toPlace() : Place {
        return Place(fourSquareId, placeName, placeAddress)
    }

    private fun PlaceRemoteModel.toLocalModel() : PlaceLocalModel {
        return PlaceLocalModel(fourSquareId, placeName, placeAddress)
    }
}