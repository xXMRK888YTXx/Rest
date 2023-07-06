package com.xxmrk888ytxx.rest.glue.ViewPlaceScreen

import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepository
import com.xxmrk888ytxx.viewplacescreen.ProvidePlaceContract
import com.xxmrk888ytxx.viewplacescreen.models.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProvidePlaceContractImpl @Inject constructor(
    private val placeRepository: PlaceRepository
) : ProvidePlaceContract {


    override fun getPlace(id: String): Flow<Place> {
        return placeRepository.getPlaceById(id).map {
            Place(it.fourSquareId,it.placeName,it.placeAddress)
        }
    }
}