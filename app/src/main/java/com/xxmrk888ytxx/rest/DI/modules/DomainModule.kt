package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.domain.TokenHolder
import com.xxmrk888ytxx.rest.domain.TokenHolderImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindTokenHolder(tokenHolderImpl: TokenHolderImpl) : TokenHolder
}