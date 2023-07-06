package com.xxmrk888ytxx.rest.useCase.LogoutUseCase

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator

interface LogoutUseCase {

    suspend fun execute(navigator: Navigator)
}