package com.xxmrk888ytxx.placeapi.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlaceApiModel(
    @SerialName("fsq_id") val fourSquareId:String,
    @SerialName("name") val placeName:String,
    @SerialName("location") val location: Location
)
