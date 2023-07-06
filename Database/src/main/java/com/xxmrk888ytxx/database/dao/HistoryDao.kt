package com.xxmrk888ytxx.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xxmrk888ytxx.database.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @get:Query("SELECT * FROM HistoryTable")
    val historyFlow: Flow<List<HistoryEntity>>

    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

}