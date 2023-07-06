package com.xxmrk888ytxx.historyscreen

import androidx.lifecycle.ViewModel
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiModel
import com.xxmrk888ytxx.historyscreen.models.ScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val historyContract: ProvideHistoryContract
) : ViewModel(),UiModel<ScreenState> {
    override fun handleEvent(event: UiEvent) {

    }

    override val state: Flow<ScreenState> = historyContract.history.map {
        ScreenState(it)
    }

    override val initialValue: ScreenState = ScreenState(emptyList())
}