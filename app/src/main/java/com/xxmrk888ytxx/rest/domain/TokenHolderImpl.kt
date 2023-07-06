package com.xxmrk888ytxx.rest.domain

import androidx.datastore.preferences.core.stringPreferencesKey
import com.xxmrk888ytxx.preferencesstorage.PreferencesStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenHolderImpl @Inject constructor(
    private val preferencesStorage: PreferencesStorage
) : TokenHolder {

    private val tokenKey = stringPreferencesKey("tokenKey")

    override val tokenFlow: Flow<String?> = preferencesStorage.getPropertyOrNull(tokenKey)

    override suspend fun setToken(token: String) = withContext(Dispatchers.IO) {
        preferencesStorage.writeProperty(tokenKey,token)
    }
}