package com.xxmrk888ytxx.corecompose.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator

val LocalNavigator = compositionLocalOf<Navigator> {
    error("LocalNavigator not provided")
}