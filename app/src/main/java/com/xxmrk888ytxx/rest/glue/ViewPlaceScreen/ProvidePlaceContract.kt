package com.xxmrk888ytxx.rest.glue.ViewPlaceScreen

import com.xxmrk888ytxx.rest.domain.HistoryRepository.HistoryRepository
import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepository
import com.xxmrk888ytxx.rest.domain.models.HistoryModel
import com.xxmrk888ytxx.viewplacescreen.ProvidePlaceContract
import com.xxmrk888ytxx.viewplacescreen.models.Place
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProvidePlaceContractImpl @Inject constructor(
    private val placeRepository: PlaceRepository,
    private val historyRepository: HistoryRepository
) : ProvidePlaceContract {

    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    override fun getPlace(id: String): Flow<Place> {
        scope.launch {
            historyRepository.insert(id)
        }

        return placeRepository.getPlaceById(id).map {
            Place(it.fourSquareId,it.placeName,it.placeAddress)
        }
    }
}