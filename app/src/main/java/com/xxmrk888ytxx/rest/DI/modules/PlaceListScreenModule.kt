package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.placelistscreen.contract.ProvidePlaceContract
import com.xxmrk888ytxx.rest.glue.PlaceListScreen.ProvidePlaceContractImpl
import dagger.Binds
import dagger.Module

@Module
interface PlaceListScreenModule {

    @Binds
    fun bindProvidePlaceContract(ProvidePlaceContractImpl: ProvidePlaceContractImpl) : ProvidePlaceContract
}