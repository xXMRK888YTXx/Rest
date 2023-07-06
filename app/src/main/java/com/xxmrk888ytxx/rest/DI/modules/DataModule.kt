package com.xxmrk888ytxx.rest.DI.modules

import android.content.Context
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
    }
}