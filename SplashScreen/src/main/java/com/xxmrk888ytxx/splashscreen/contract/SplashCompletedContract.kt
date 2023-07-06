package com.xxmrk888ytxx.splashscreen.contract

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator

interface SplashCompletedContract {

    suspend fun onSplashCompleted(navigator: Navigator)
}