package com.xxmrk888ytxx.viewplacescreen

import androidx.lifecycle.ViewModel
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiModel
import com.xxmrk888ytxx.viewplacescreen.models.ScreenState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ViewPlaceViewModel @AssistedInject constructor(
    @Assisted private val placeId:String,
    private val providePlaceContract: ProvidePlaceContract
) : ViewModel(),UiModel<ScreenState> {

    override fun handleEvent(event: UiEvent) {

    }

    override val state: Flow<ScreenState> = providePlaceContract.getPlace(placeId).map {
        ScreenState(it)
    }


    override val initialValue: ScreenState
        get() = ScreenState()

    @AssistedFactory
    interface Factory {
        fun create(placeId: String) : ViewPlaceViewModel
    }
}