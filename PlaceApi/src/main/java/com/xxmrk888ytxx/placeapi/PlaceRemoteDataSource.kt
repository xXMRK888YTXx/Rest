package com.xxmrk888ytxx.placeapi

import com.xxmrk888ytxx.placeapi.models.PlaceRemoteModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging

interface PlaceRemoteDataSource {

    suspend fun getPlaces(token:String) : List<PlaceRemoteModel>

    companion object {
        fun create() : PlaceRemoteDataSource {
            val json = kotlinx.serialization.json.Json {
                this.encodeDefaults = true
                ignoreUnknownKeys = true
            }

            val client = HttpClient(Android) {
                engine {
                    connectTimeout = 10000
                    socketTimeout = 10000
                }

                install(JsonFeature) {
                    serializer = KotlinxSerializer(json)
                }
                install(Logging)
            }

            val api = PlaceApiImpl(client)


            return PlaceRemoteDataSourceImpl(api)
        }
    }
}