package com.xxmrk888ytxx.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "PlaceTable",
    indices = [
        Index("fourSquareId", unique = true)
    ]
)
internal data class PlaceEntity(
    @PrimaryKey val fourSquareId:String,
    val placeName:String,
    val placeAddress:String
)
