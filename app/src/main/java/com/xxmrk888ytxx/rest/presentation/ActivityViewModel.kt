package com.xxmrk888ytxx.rest.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.runOnUiThread

internal class ActivityViewModel : ViewModel(),Navigator {

    var navController:NavController? = null

    override fun toAuthScreen() = runOnUiThread {
        navController?.navigate(Screen.AuthScreen.route) { launchSingleTop = true }

        navController?.popBackStack(Screen.SplashScreen.route,inclusive = true)
    }

    override fun toMainScreen() {
        navController?.navigate(Screen.MainScreen.route)

        navController?.popBackStack(Screen.MainScreen.route,false)
    }


}