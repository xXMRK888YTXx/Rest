package com.xxmrk888ytxx.rest.domain.TokenHolder

import kotlinx.coroutines.flow.Flow

interface TokenHolder {

    val tokenFlow: Flow<String?>

    val cashedToken: String?

    suspend fun dropToken()

    suspend fun setToken(token:String)
}