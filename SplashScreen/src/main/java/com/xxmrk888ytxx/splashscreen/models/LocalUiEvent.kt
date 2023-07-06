package com.xxmrk888ytxx.splashscreen.models

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent

internal sealed class LocalUiEvent : UiEvent {

    class StartSplashEvent(val navigator: Navigator) : LocalUiEvent()
}