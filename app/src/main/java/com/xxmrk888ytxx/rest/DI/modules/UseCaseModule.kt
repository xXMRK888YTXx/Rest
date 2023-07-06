package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.useCase.ProvideTokenUseCase.ProvideTokenUseCase
import com.xxmrk888ytxx.rest.useCase.ProvideTokenUseCase.ProvideTokenUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindProvideTokenUseCase(
        ProvideTokenUseCase:ProvideTokenUseCaseImpl
    ) : ProvideTokenUseCase
}