package com.xxmrk888ytxx.placeapi

import com.xxmrk888ytxx.placeapi.models.api.PlaceApiModel

internal interface PlaceApi {

    suspend fun getPlaces(token:String) : List<PlaceApiModel>
}