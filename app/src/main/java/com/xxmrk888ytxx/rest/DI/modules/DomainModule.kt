package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepository
import com.xxmrk888ytxx.rest.domain.PlaceRepository.PlaceRepositoryImpl
import com.xxmrk888ytxx.rest.domain.TokenHolder.TokenHolder
import com.xxmrk888ytxx.rest.domain.TokenHolder.TokenHolderImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindTokenHolder(tokenHolderImpl: TokenHolderImpl) : TokenHolder

    @Binds
    fun bindPlaceRepository(placeRepository: PlaceRepositoryImpl) : PlaceRepository
}