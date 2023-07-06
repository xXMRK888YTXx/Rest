package com.xxmrk888ytxx.authscreen

import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator


interface AuthRequestContact {

    suspend fun authRequest(navigator:Navigator)
}