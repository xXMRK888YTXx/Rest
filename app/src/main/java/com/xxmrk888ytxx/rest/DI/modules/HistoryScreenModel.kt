package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.historyscreen.ProvideHistoryContract
import com.xxmrk888ytxx.rest.glue.HistoryScreen.ProvideHistoryContractImpl
import dagger.Binds
import dagger.Module

@Module
interface HistoryScreenModel {

    @Binds
    fun bindProvideHistoryContract(
        ProvideHistoryContractImpl: ProvideHistoryContractImpl
    ) : ProvideHistoryContract
}