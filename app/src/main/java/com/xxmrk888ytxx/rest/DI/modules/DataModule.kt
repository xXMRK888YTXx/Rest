package com.xxmrk888ytxx.rest.DI.modules

import android.content.Context
import com.xxmrk888ytxx.authapi.AuthApi
import com.xxmrk888ytxx.database.Database
import com.xxmrk888ytxx.database.dataSources.PlaceLocalDataSource
import com.xxmrk888ytxx.placeapi.PlaceRemoteDataSource
import com.xxmrk888ytxx.preferencesstorage.PreferencesStorage
import com.xxmrk888ytxx.rest.DI.AppScope
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    companion object {
        @Provides
        @AppScope
        fun providePreferenceStorage(context: Context) : PreferencesStorage {
            return PreferencesStorage.Factory().create("preferences",context)
        }

        @Provides
        fun provideAuthApi() : AuthApi {
            return AuthApi.create()
        }

        @Provides
        @AppScope
        fun provideDatabase(context: Context) : Database {
            return Database.create(context)
        }

        @Provides
        fun providePlaceLocalDataSource(database: Database) : PlaceLocalDataSource {
            return database.placeLocalDataSource
        }

        @Provides
        @AppScope
        fun providePlaceRemoteDataSource() : PlaceRemoteDataSource {
            return PlaceRemoteDataSource.create()
        }

        @Provides
        fun provideHistoryLocalDataSource(database: Database) = database.historyLocalDataSource
    }
}