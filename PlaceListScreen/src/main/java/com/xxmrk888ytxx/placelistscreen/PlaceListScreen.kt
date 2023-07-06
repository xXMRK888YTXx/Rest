package com.xxmrk888ytxx.placelistscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.placelistscreen.models.LocalUiEvent
import com.xxmrk888ytxx.placelistscreen.models.ScreenState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlaceListScreen(
    screenState: ScreenState,
    onEvent:(UiEvent) -> Unit
) {

    val context = LocalContext.current

    val pullRefreshState = rememberPullRefreshState(
        refreshing = screenState.isLoadingData,
        onRefresh = { onEvent(LocalUiEvent.UpdatePlaces()) }
    )

    Box(
        modifier = Modifier.fillMaxSize()
        .pullRefresh(pullRefreshState),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)) {
            if(screenState.places.isEmpty()) {
                item {
                    Box(Modifier.fillMaxSize()) {
                        Text(text = "No places")
                    }
                }
            } else {
                items(screenState.places,key = { it.id }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Name:${it.name}")

                            Text(text = "id:${it.id}")

                            Text(text = "Address:${it.address}")
                        }
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = screenState.isLoadingData,
            state = pullRefreshState
        )
    }


}