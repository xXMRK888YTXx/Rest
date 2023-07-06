package com.xxmrk888ytxx.rest.domain

import kotlinx.coroutines.flow.Flow

interface TokenHolder {

    val tokenFlow: Flow<String?>

    suspend fun setToken(token:String)
}