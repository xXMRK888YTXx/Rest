package com.xxmrk888ytxx.rest.glue.PlaceListScreen

import com.xxmrk888ytxx.placelistscreen.contract.ProvidePlaceContract
import com.xxmrk888ytxx.placelistscreen.models.Place
import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProvidePlaceContractImpl @Inject constructor(
    private val placeRepository: PlaceRepository
) : ProvidePlaceContract {

    override val places: Flow<List<Place>> = placeRepository.places.map { list ->
        list.map { Place(it.fourSquareId,it.placeName,it.placeAddress) }
    }

    override suspend fun refresh() {
        placeRepository.load()
    }
}