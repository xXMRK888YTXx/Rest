package com.xxmrk888ytxx.database

import android.content.Context
import com.xxmrk888ytxx.database.dataSources.HistoryLocalDataSource
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource

interface Database {

    val placeLocalDataSource:PlaceLocalDataSource

    val historyLocalDataSource: HistoryLocalDataSource
    companion object {
        fun create(context:Context) : Database {
            return DatabaseImpl(context)
        }
    }
}