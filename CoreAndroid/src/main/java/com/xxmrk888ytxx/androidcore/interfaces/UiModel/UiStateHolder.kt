package com.xxmrk888ytxx.androidcore.interfaces.UiModel

import kotlinx.coroutines.flow.Flow

interface UiStateHolder<STATE> {

    val state:Flow<STATE>

    val initialValue: STATE
}