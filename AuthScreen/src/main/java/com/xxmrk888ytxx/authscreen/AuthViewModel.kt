package com.xxmrk888ytxx.authscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiModel
import com.xxmrk888ytxx.authscreen.models.LocalUiEvent
import com.xxmrk888ytxx.authscreen.models.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authRequestContact: AuthRequestContact
) : ViewModel(),UiModel<ScreenState> {

    override fun handleEvent(event: UiEvent) {
        if(event !is LocalUiEvent) return

        when(event) {
            is LocalUiEvent.AuthRequestEvent -> {
                _state.update { it.copy(isLoading = true) }

                viewModelScope.launch(Dispatchers.IO) {
                    authRequestContact.authRequest(event.navigator)
                }
            }
        }
    }

    private val _state = MutableStateFlow(ScreenState())

    override val state: Flow<ScreenState> = _state.map {
        cashedState = it

        it
    }

    private var cashedState = ScreenState()

    override val initialValue: ScreenState
        get() = cashedState
}