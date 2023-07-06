package com.xxmrk888ytxx.placelistscreen.models

import android.content.Context
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent

sealed class LocalUiEvent : UiEvent {

    class UpdatePlaces() : LocalUiEvent()
}
