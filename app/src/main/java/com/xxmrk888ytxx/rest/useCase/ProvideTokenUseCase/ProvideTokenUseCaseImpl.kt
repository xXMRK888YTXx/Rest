package com.xxmrk888ytxx.rest.useCase.ProvideTokenUseCase

import com.xxmrk888ytxx.authapi.AuthApi
import com.xxmrk888ytxx.rest.domain.TokenHolder.TokenHolder
import javax.inject.Inject

class ProvideTokenUseCaseImpl @Inject constructor(
    private val tokenHolder: TokenHolder,
    private val authApi: AuthApi
) : ProvideTokenUseCase {


    override suspend fun execute() {
        tokenHolder.setToken(authApi.getToken().token)
    }
}