package com.xxmrk888ytxx.placeapi.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RemoteResponse(
    @SerialName("results") val placeList:List<PlaceApiModel>
)
