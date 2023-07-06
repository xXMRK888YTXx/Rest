package com.xxmrk888ytxx.database.dataSources

import androidx.room.Insert
import androidx.room.Query
import com.xxmrk888ytxx.database.entity.HistoryEntity
import com.xxmrk888ytxx.database.models.HistoryLocalModel
import kotlinx.coroutines.flow.Flow

interface HistoryLocalDataSource {

    val historyFlow: Flow<List<HistoryLocalModel>>

    suspend fun insert(historyLocalModel: HistoryLocalModel)
}