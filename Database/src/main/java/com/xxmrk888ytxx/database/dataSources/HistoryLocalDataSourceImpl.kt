package com.xxmrk888ytxx.database.dataSources

import com.xxmrk888ytxx.database.dao.HistoryDao
import com.xxmrk888ytxx.database.entity.HistoryEntity
import com.xxmrk888ytxx.database.models.HistoryLocalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class HistoryLocalDataSourceImpl constructor(
    private val historyDao: HistoryDao
) : HistoryLocalDataSource {

    override val historyFlow: Flow<List<HistoryLocalModel>> = historyDao.historyFlow.map {
        list -> list.map { it.toLocalModel() }
    }

    override suspend fun insert(historyLocalModel: HistoryLocalModel) = withContext(Dispatchers.IO) {
        historyDao.insert(historyLocalModel.toEntity())
    }

    private fun HistoryEntity.toLocalModel() : HistoryLocalModel {
        return HistoryLocalModel(id, placeId)
    }

    private fun HistoryLocalModel.toEntity() : HistoryEntity {
        return HistoryEntity(id, placeId)
    }
}