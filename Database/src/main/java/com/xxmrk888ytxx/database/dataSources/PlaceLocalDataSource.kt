package com.xxmrk888ytxx.database.dataSources

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xxmrk888ytxx.database.entity.PlaceEntity
import com.xxmrk888ytxx.database.models.PlaceLocalModel
import kotlinx.coroutines.flow.Flow

interface PlaceLocalDataSource {

    val placesFlow: Flow<List<PlaceLocalModel>>

    suspend fun insert(placeEntity: PlaceLocalModel)

    suspend fun dropData()
}