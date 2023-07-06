package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.domain.HistoryRepository.HistoryRepository
import com.xxmrk888ytxx.rest.domain.HistoryRepository.HistoryRepositoryImpl
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

    @Binds
    fun bindHistoryRepository(HistoryRepositoryImpl: HistoryRepositoryImpl) : HistoryRepository
}