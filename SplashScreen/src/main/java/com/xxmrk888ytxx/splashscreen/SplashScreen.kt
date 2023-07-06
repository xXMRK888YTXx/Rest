package com.xxmrk888ytxx.splashscreen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.corecompose.ui.theme.LocalNavigator
import com.xxmrk888ytxx.splashscreen.models.LocalUiEvent
import dagger.Component

@Composable
fun SplashScreen(
    onEvent:(UiEvent) -> Unit
) {

    val navigator = LocalNavigator.current

    LaunchedEffect(key1 = Unit, block = {
        onEvent(LocalUiEvent.StartSplashEvent(navigator))
    })

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Image(
            painter = painterResource(id = R.drawable.foursquare),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )
    }
}