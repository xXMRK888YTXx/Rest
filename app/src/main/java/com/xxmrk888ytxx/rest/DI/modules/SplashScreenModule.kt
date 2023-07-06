package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.rest.glue.SplashScreen.SplashCompletedContractImpl
import com.xxmrk888ytxx.splashscreen.contract.SplashCompletedContract
import dagger.Binds
import dagger.Module

@Module
interface SplashScreenModule {

    @Binds
    fun bindSplashCompletedContractImpl(
        splashCompletedContractImpl: SplashCompletedContractImpl
    ): SplashCompletedContract
}