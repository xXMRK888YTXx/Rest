package com.xxmrk888ytxx.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.xxmrk888ytxx.database.entity.PlaceEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface PlaceDao {

    @get:Query("SELECT * FROM PlaceTable")
    val placesFlow: Flow<List<PlaceEntity>>

    @Query("SELECT * FROM PlaceTable WHERE fourSquareId = :id")
    fun getPlaceById(id:String) : Flow<PlaceEntity>

    @Insert(onConflict = IGNORE)
    suspend fun insert(placeEntity: PlaceEntity)

    @Query("DELETE FROM PlaceTable")
    suspend fun dropData()
}