package com.xxmrk888ytxx.rest.glue.AuthScreen

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.authscreen.AuthRequestContact
import com.xxmrk888ytxx.rest.useCase.ProvideTokenUseCase.ProvideTokenUseCase
import javax.inject.Inject

class AuthRequestContactImpl @Inject constructor(
    private val provideTokenUseCase: ProvideTokenUseCase
) : AuthRequestContact {

    override suspend fun authRequest(navigator: Navigator) {
        try {
            provideTokenUseCase.execute()

            navigator.toMainScreen()
        }catch (_:Exception) { }
    }
}