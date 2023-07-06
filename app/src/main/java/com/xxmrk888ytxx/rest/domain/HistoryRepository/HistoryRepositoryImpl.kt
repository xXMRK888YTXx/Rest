package com.xxmrk888ytxx.rest.domain.HistoryRepository

import com.xxmrk888ytxx.database.dataSources.HistoryLocalDataSource
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource
import com.xxmrk888ytxx.database.models.HistoryLocalModel
import com.xxmrk888ytxx.database.models.PlaceLocalModel
import com.xxmrk888ytxx.rest.domain.models.HistoryModel
import com.xxmrk888ytxx.rest.domain.models.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyLocalDataSource: HistoryLocalDataSource,
    private val placeLocalDataSource: PlaceLocalDataSource
) : HistoryRepository {
    override suspend fun insert(historyModel: HistoryModel) {
        historyLocalDataSource.insert(HistoryLocalModel(historyModel.id,historyModel.place.fourSquareId))
    }

    override suspend fun insert(placeId: String) {
        historyLocalDataSource.insert(HistoryLocalModel(0,placeId))
    }

    override val historyModels: Flow<List<HistoryModel>> = combine(
        historyLocalDataSource.historyFlow,
        placeLocalDataSource.placesFlow
    ) { historyModels,placesModel ->
        val finalList = mutableListOf<HistoryModel>()
        val placeMap = mutableMapOf<String,Place>()

        placesModel.forEach {
            placeMap[it.fourSquareId] = Place(it.fourSquareId,it.placeName,it.placeAddress)
        }

        historyModels.forEach {
            placeMap[it.placeId]?.let { place ->
                finalList.add(HistoryModel(it.id,place))
            }
        }

        finalList

    }
}