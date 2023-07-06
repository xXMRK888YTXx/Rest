package com.xxmrk888ytxx.authapi

import com.xxmrk888ytxx.authapi.models.Token
import kotlinx.coroutines.delay

internal class AuthApiImpl : AuthApi {
    override suspend fun getToken(): Token {
        delay(1000)

        return Token("fsq3/a64Fo9NwAgGF+m2a4EunU6zTn0bbV5a4mtshp7Th6U=")
    }
}