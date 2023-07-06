package com.xxmrk888ytxx.rest.presentation

sealed class Screen(val route:String) {

    object SplashScreen : Screen("SplashScreen")

    object AuthScreen : Screen("AuthScreen")

    object MainScreen : Screen("MainScreen")
}
