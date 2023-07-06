package com.xxmrk888ytxx.rest.domain.PlaceRepository

import com.xxmrk888ytxx.rest.domain.models.Place
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {

    val places: Flow<List<Place>>

    fun getPlaceById(id:String) : Flow<Place>

    suspend fun dropCached()

    suspend fun load()
}