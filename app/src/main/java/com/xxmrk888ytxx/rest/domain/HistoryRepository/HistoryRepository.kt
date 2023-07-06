package com.xxmrk888ytxx.rest.domain.HistoryRepository

import com.xxmrk888ytxx.rest.domain.models.HistoryModel
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insert(historyModel: HistoryModel)

    val historyModels: Flow<List<HistoryModel>>
}