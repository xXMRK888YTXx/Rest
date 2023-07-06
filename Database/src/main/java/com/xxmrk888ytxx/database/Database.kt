package com.xxmrk888ytxx.database

import android.content.Context
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource

interface Database {

    val placeLocalDataSource:PlaceLocalDataSource

    companion object {
        fun create(context:Context) : Database {
            return DatabaseImpl(context)
        }
    }
}