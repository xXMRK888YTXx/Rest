package com.xxmrk888ytxx.placelistscreen.contract

import com.xxmrk888ytxx.placelistscreen.models.Place
import kotlinx.coroutines.flow.Flow

interface ProvidePlaceContract {

    val places: Flow<List<Place>>

    suspend fun refresh()
}