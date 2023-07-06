package com.xxmrk888ytxx.placelistscreen.models

data class ScreenState(
    val isLoadingData:Boolean = false,
    val places:List<Place> = emptyList()
)
