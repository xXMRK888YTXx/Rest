package com.xxmrk888ytxx.rest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xxmrk888ytxx.rest.extensions.appComponent
import com.xxmrk888ytxx.rest.extensions.setContentWithTheme

class MainActivity : ComponentActivity() {

    private val activityViewModel by viewModels<ActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContentWithTheme {
            val navController = rememberNavController()

            LaunchedEffect(key1 = navController, block = {
                activityViewModel.navController = navController
            })

            NavigationHost(
                navController = navController,
                navigator = activityViewModel,
                startDestination = Screen.SplashScreen.route
            ){

                composable(Screen.SplashScreen.route) {

                }
            }
        }
    }
}