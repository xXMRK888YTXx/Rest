package com.xxmrk888ytxx.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEventHandler
import com.xxmrk888ytxx.splashscreen.contract.SplashCompletedContract
import com.xxmrk888ytxx.splashscreen.models.LocalUiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashCompletedContract: SplashCompletedContract
) : ViewModel(),UiEventHandler {


    private var isStared = false

    override fun handleEvent(event: UiEvent) {
        if(event !is LocalUiEvent) return


        when(event) {
            is LocalUiEvent.StartSplashEvent -> {
                if(isStared) return

                isStared = true

                startTimer(event.navigator)
            }
        }
    }

    private fun startTimer(navigator: Navigator) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            splashCompletedContract.onSplashCompleted(navigator)
        }
    }


}