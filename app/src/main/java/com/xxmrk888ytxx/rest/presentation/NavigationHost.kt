package com.xxmrk888ytxx.rest.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.corecompose.ui.theme.LocalNavigator

@Composable
fun NavigationHost(
    navController: NavHostController,
    navigator: Navigator,
    startDestination: String,
    builder: NavGraphBuilder.() -> Unit
) {
    CompositionLocalProvider(
        LocalNavigator provides navigator
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            navController = navController,
            startDestination = startDestination,
            builder = builder
        )
    }
}