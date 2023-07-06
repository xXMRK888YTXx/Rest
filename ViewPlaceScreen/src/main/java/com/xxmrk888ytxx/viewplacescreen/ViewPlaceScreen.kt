package com.xxmrk888ytxx.viewplacescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.viewplacescreen.models.ScreenState

@Composable
fun ViewPlaceScreen(
    screenState: ScreenState,
    onEvent:(UiEvent) -> Unit
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            CardItem(text = "Id ${screenState.place.id}")
        }

        item {
            CardItem(text = "Name ${screenState.place.name}")
        }

        item {
            CardItem(text = "Address ${screenState.place.address}")
        }

    }
}

@Composable
private fun CardItem(
    text:String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text, style = MaterialTheme.typography.titleLarge)
        }
    }
}