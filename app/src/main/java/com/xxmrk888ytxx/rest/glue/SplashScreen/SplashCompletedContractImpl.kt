package com.xxmrk888ytxx.rest.glue.SplashScreen

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.rest.domain.TokenHolder
import com.xxmrk888ytxx.splashscreen.contract.SplashCompletedContract
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SplashCompletedContractImpl  @Inject constructor(
    private val tokenHolder: TokenHolder
) : SplashCompletedContract {
    override suspend fun onSplashCompleted(navigator: Navigator) {
        if(tokenHolder.tokenFlow.first() == null) {
            navigator.toAuthScreen()


        } else {
            navigator.toMainScreen()
        }
    }
}