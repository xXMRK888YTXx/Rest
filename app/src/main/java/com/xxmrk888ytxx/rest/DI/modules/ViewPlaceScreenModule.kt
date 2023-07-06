package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.glue.ViewPlaceScreen.ProvidePlaceContractImpl
import com.xxmrk888ytxx.viewplacescreen.ProvidePlaceContract
import dagger.Binds
import dagger.Module

@Module
interface ViewPlaceScreenModule {

    @Binds
    fun bindProvidePlaceContract(
        ProvidePlaceContractImpl: ProvidePlaceContractImpl
    ) : ProvidePlaceContract
}