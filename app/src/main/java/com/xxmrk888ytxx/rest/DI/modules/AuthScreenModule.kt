package com.xxmrk888ytxx.rest.DI.modules

import com.xxmrk888ytxx.authscreen.AuthRequestContact
import com.xxmrk888ytxx.rest.glue.AuthScreen.AuthRequestContactImpl
import dagger.Binds
import dagger.Module

@Module
interface AuthScreenModule {

    @Binds
    fun bindAuthRequestContact(
        AuthRequestContactImpl: AuthRequestContactImpl
    ) : AuthRequestContact
}