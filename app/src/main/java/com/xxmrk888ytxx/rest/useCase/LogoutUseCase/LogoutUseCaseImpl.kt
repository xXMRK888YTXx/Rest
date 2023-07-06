package com.xxmrk888ytxx.rest.useCase.LogoutUseCase

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepository
import com.xxmrk888ytxx.rest.domain.TokenHolder.TokenHolder
import javax.inject.Inject

class LogoutUseCaseImpl @Inject constructor(
    private val placeRepository: PlaceRepository,
    private val tokenHolder: TokenHolder
) : LogoutUseCase {

    override suspend fun execute(navigator: Navigator) {
        placeRepository.dropCached()
        tokenHolder.dropToken()

        navigator.toSplashScreen()
    }
}