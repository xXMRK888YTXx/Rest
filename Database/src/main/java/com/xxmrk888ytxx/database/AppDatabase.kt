package com.xxmrk888ytxx.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xxmrk888ytxx.database.dao.HistoryDao
import com.xxmrk888ytxx.database.dao.PlaceDao
import com.xxmrk888ytxx.database.entity.HistoryEntity
import com.xxmrk888ytxx.database.entity.PlaceEntity

@Database(
    version = 1,
    entities = [
        PlaceEntity::class,
        HistoryEntity::class
    ]
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract val placeDao:PlaceDao

    abstract val historyDao:HistoryDao
}