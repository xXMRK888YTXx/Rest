package com.xxmrk888ytxx.placeapi

import com.xxmrk888ytxx.placeapi.models.PlaceRemoteModel

internal class PlaceRemoteDataSourceImpl(
    private val placeApi: PlaceApi
) : PlaceRemoteDataSource {

    override suspend fun getPlaces(token: String): List<PlaceRemoteModel> {
        return placeApi.getPlaces(token).map {
            PlaceRemoteModel(it.fourSquareId,it.placeName,it.location.address)
        }
    }
}