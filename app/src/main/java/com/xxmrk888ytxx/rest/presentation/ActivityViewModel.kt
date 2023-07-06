package com.xxmrk888ytxx.rest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.Navigator
import com.xxmrk888ytxx.androidcore.runOnUiThread
import com.xxmrk888ytxx.rest.useCase.LogoutUseCase.LogoutUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    override fun toViewPlaceScreen(id: String) = runOnUiThread {
        navController?.navigate("${Screen.ViewPlaceScreen.route}/${id}") {
            launchSingleTop = true
        }
    }

    override fun toSplashScreen() = runOnUiThread {
        navController?.popBackStack()
        navController?.navigate(Screen.SplashScreen.route) { launchSingleTop = true }
    }

    fun logout(logoutUseCase: LogoutUseCase) {
        viewModelScope.launch(Dispatchers.IO) {
            logoutUseCase.execute(this@ActivityViewModel)
        }
    }


}