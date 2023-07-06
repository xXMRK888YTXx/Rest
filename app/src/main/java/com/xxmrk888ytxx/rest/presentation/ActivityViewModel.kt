package com.xxmrk888ytxx.rest.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.runOnUiThread

internal class ActivityViewModel : ViewModel(),Navigator {

    var navController:NavController? = null

    override fun toAuthScreen() = runOnUiThread {
        navController?.navigate(Screen.AuthScreen.route) {
            launchSingleTop = true

            popUpTo(Screen.SplashScreen.route) { inclusive = true }

        }

    }

    override fun toMainScreen() = runOnUiThread {
        navController?.popBackStack()
        navController?.navigate(Screen.MainScreen.route) {

            popUpTo(Screen.AuthScreen.route) { inclusive = true }

            launchSingleTop = true
        }

    }


}