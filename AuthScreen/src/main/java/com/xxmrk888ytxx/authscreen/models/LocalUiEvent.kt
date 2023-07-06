package com.xxmrk888ytxx.authscreen.models

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent

sealed class LocalUiEvent : UiEvent {

    class AuthRequestEvent(val navigator: Navigator) : LocalUiEvent()
}
