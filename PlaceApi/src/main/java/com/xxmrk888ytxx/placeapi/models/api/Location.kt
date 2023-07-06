package com.xxmrk888ytxx.placeapi.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
   @SerialName("formatted_address") val address:String
)
