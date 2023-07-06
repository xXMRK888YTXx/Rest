package com.xxmrk888ytxx.placeapi

import com.xxmrk888ytxx.placeapi.models.api.PlaceApiModel
import com.xxmrk888ytxx.placeapi.models.api.RemoteResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class PlaceApiImpl(
    private val httpClient: HttpClient
) : PlaceApi {

    override suspend fun getPlaces(token: String): List<PlaceApiModel> = withContext(Dispatchers.IO) {
        return@withContext httpClient.get<RemoteResponse> {
            header("Authorization",token)
            url("https://api.foursquare.com/v3/places/search?ll=53.9057644,27.5582305&radius=4000&limit=30")

        }.placeList
    }
}