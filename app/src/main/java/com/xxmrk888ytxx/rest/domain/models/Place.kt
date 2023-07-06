package com.xxmrk888ytxx.rest.domain.models

import androidx.room.PrimaryKey

data class Place(
    @PrimaryKey val fourSquareId:String,
    val placeName:String,
    val placeAddress:String
)
