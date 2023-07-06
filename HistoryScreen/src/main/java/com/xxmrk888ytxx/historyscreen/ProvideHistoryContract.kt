package com.xxmrk888ytxx.historyscreen

import com.xxmrk888ytxx.historyscreen.models.HistoryModel
import kotlinx.coroutines.flow.Flow

interface ProvideHistoryContract {

    val history: Flow<List<HistoryModel>>
}