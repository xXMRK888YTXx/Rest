package com.xxmrk888ytxx.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "HistoryTable",
    indices = [
        Index("id", unique = true),
        Index("placeId", unique = true),
    ],
    foreignKeys = [
        ForeignKey(
            entity = PlaceEntity::class,
            parentColumns = ["fourSquareId"],
            childColumns = ["id"],
            onUpdate = CASCADE,
            onDelete = CASCADE
        )
    ]
)
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val placeId:String
)