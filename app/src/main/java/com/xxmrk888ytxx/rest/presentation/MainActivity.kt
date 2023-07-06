package com.xxmrk888ytxx.rest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xxmrk888ytxx.authscreen.AuthScreen
import com.xxmrk888ytxx.authscreen.AuthViewModel
import com.xxmrk888ytxx.bottombarscreen.BottomBarScreen
import com.xxmrk888ytxx.bottombarscreen.models.BottomBarScreenModel
import com.xxmrk888ytxx.goals.R
import com.xxmrk888ytxx.placelistscreen.PlaceListScreen
import com.xxmrk888ytxx.placelistscreen.PlaceListViewModel
import com.xxmrk888ytxx.rest.extensions.appComponent
import com.xxmrk888ytxx.rest.extensions.composeViewModel
import com.xxmrk888ytxx.rest.extensions.setContentWithTheme
import com.xxmrk888ytxx.splashscreen.SplashScreen
import com.xxmrk888ytxx.splashscreen.SplashViewModel
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : ComponentActivity() {

    private val activityViewModel by viewModels<ActivityViewModel>()

    @Inject
    lateinit var splashViewModel: Provider<SplashViewModel>

    @Inject
    lateinit var authViewModel: Provider<AuthViewModel>

    @Inject
    lateinit var placeListViewModel: Provider<PlaceListViewModel>


    @SuppressLint("ResourceType")
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
            ) {

                composable(Screen.SplashScreen.route) {
                    val viewModel = composeViewModel {
                        splashViewModel.get()
                    }

                    SplashScreen(onEvent = viewModel::handleEvent)
                }

                composable(Screen.AuthScreen.route) {
                    val viewModel = composeViewModel() {
                        authViewModel.get()
                    }

                    val screenState by viewModel.state.collectAsStateWithLifecycle(initialValue = viewModel.initialValue)

                    AuthScreen(screenState = screenState, onEvent = viewModel::handleEvent)
                }

                composable(Screen.MainScreen.route) {

                    val viewModelForPlaceListScreen = composeViewModel() {
                        placeListViewModel.get()
                    }

                    val screenStateForPlaceListScreen by viewModelForPlaceListScreen.state.collectAsStateWithLifecycle(
                        initialValue = viewModelForPlaceListScreen.initialValue
                    )

                    BottomBarScreen(bottomBarScreens = persistentListOf(
                        BottomBarScreenModel(
                            title = "Places",
                            icon = R.drawable.baseline_place_24,
                            content = {
                                PlaceListScreen(
                                    screenState = screenStateForPlaceListScreen,
                                    onEvent = viewModelForPlaceListScreen::handleEvent
                                )
                            }
                        ),
                        BottomBarScreenModel(
                            title = "History",
                            icon = R.drawable.baseline_history_24,
                            content = {}
                        )
                    ))
                }
            }
        }
    }
}