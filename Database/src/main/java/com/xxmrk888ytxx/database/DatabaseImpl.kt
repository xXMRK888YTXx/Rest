package com.xxmrk888ytxx.database

import android.content.Context
import androidx.room.Room
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSourceImpl

internal class DatabaseImpl(private val context: Context) : Database {

    private val database by lazy {
        Room.databaseBuilder(context,AppDatabase::class.java,"database.db").build()
    }

    override val placeLocalDataSource: PlaceLocalDataSource by lazy {
        PlaceLocalDataSourceImpl(database.placeDao)
    }
}