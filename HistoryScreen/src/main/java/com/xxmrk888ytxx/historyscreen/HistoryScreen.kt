package com.xxmrk888ytxx.historyscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.historyscreen.models.ScreenState

@Composable
fun HistoryScreen(
    screenState: ScreenState,
    onEvent:(UiEvent) -> Unit
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
    ) {
        if(screenState.historyModel.isEmpty()) {
            item {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "No places")
                }
            }
        } else {
            items(screenState.historyModel,key = { it.localId }) {
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

                        Text(text = "id:${it.placeId}")

                        Text(text = "Address:${it.address}")
                    }
                }
            }
        }
    }
}