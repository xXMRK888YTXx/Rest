package com.xxmrk888ytxx.placelistscreen.models

import android.content.Context
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent

sealed class LocalUiEvent : UiEvent {

    class UpdatePlaces() : LocalUiEvent()
    class ViewPlace(val navigator: Navigator,val id:String) : LocalUiEvent()
}
