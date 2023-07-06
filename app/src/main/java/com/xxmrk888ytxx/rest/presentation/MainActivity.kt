package com.xxmrk888ytxx.rest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xxmrk888ytxx.authscreen.AuthScreen
import com.xxmrk888ytxx.authscreen.AuthViewModel
import com.xxmrk888ytxx.bottombarscreen.BottomBarScreen
import com.xxmrk888ytxx.bottombarscreen.models.BottomBarScreenModel
import com.xxmrk888ytxx.goals.R
import com.xxmrk888ytxx.historyscreen.HistoryScreen
import com.xxmrk888ytxx.historyscreen.HistoryViewModel
import com.xxmrk888ytxx.placelistscreen.PlaceListScreen
import com.xxmrk888ytxx.placelistscreen.PlaceListViewModel
import com.xxmrk888ytxx.rest.extensions.appComponent
import com.xxmrk888ytxx.rest.extensions.composeViewModel
import com.xxmrk888ytxx.rest.extensions.setContentWithTheme
import com.xxmrk888ytxx.rest.useCase.LogoutUseCase.LogoutUseCase
import com.xxmrk888ytxx.splashscreen.SplashScreen
import com.xxmrk888ytxx.splashscreen.SplashViewModel
import com.xxmrk888ytxx.viewplacescreen.ViewPlaceScreen
import com.xxmrk888ytxx.viewplacescreen.ViewPlaceViewModel
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

    @Inject
    lateinit var viewPlaceViewModel: ViewPlaceViewModel.Factory

    @Inject
    lateinit var historyViewModel: Provider<HistoryViewModel>

    @Inject
    lateinit var logoutUseCase: LogoutUseCase

    @OptIn(ExperimentalMaterial3Api::class)
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
                    //

                    val viewModelForHistoryScreen = composeViewModel() {
                        historyViewModel.get()
                    }

                    val screenStateForHistoryScreen by viewModelForHistoryScreen.state.collectAsStateWithLifecycle(
                        initialValue = viewModelForHistoryScreen.initialValue
                    )

                    BottomBarScreen(
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(
                                        text = "FourSquare",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                },
                                navigationIcon = {
                                    IconButton(onClick = { activityViewModel.logout(logoutUseCase) }) {
                                        Icon(
                                            painterResource(id = R.drawable.baseline_logout_24),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            )
                        },
                        bottomBarScreens = persistentListOf(
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
                                content = {
                                    HistoryScreen(
                                        screenState = screenStateForHistoryScreen,
                                        onEvent = viewModelForHistoryScreen::handleEvent
                                    )
                                }
                            )
                        ))
                }

                composable(
                    "${Screen.ViewPlaceScreen.route}/{id}",
                    arguments = listOf(
                        navArgument("id") {
                            this.type = NavType.StringType
                        }
                    )
                ) {
                    val id = it.arguments?.getString("id") ?: return@composable

                    val viewModel = composeViewModel() {
                        viewPlaceViewModel.create(id)
                    }

                    val screenState by viewModel.state.collectAsStateWithLifecycle(initialValue = viewModel.initialValue)

                    ViewPlaceScreen(screenState = screenState, onEvent = viewModel::handleEvent)
                }
            }
        }
    }
}