package com.xxmrk888ytxx.authapi

import com.xxmrk888ytxx.authapi.models.Token

interface AuthApi {

    suspend fun getToken() : Token

    companion object {
        fun create() : AuthApi {
            return AuthApiImpl()
        }
    }
}