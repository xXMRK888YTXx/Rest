package com.xxmrk888ytxx.authscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.authscreen.models.LocalUiEvent
import com.xxmrk888ytxx.authscreen.models.ScreenState
import com.xxmrk888ytxx.corecompose.ui.theme.LocalNavigator

@Composable
fun AuthScreen(
    screenState: ScreenState,
    onEvent:(UiEvent) -> Unit
) {

    val navigator = LocalNavigator.current
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        
        if(screenState.isLoading) {
            CircularProgressIndicator()
        } else {
            Button(onClick = { onEvent(LocalUiEvent.AuthRequestEvent(navigator)) }) {
                Text(text = "Connect to FourSquare")
            }
        }
    }
}