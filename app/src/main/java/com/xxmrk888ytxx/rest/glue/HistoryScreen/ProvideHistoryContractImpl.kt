package com.xxmrk888ytxx.rest.glue.HistoryScreen

import com.xxmrk888ytxx.historyscreen.ProvideHistoryContract
import com.xxmrk888ytxx.historyscreen.models.HistoryModel
import com.xxmrk888ytxx.rest.domain.HistoryRepository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProvideHistoryContractImpl @Inject constructor (
    private val historyRepository: HistoryRepository
) : ProvideHistoryContract {

    override val history: Flow<List<HistoryModel>> = historyRepository.historyModels.map { list ->
        list.map { HistoryModel(it.id,it.place.fourSquareId,it.place.placeName,it.place.placeAddress) }
    }

}