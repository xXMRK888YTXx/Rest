package com.xxmrk888ytxx.placelistscreen

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiEvent
import com.xxmrk888ytxx.androidcore.interfaces.UiModel.UiModel
import com.xxmrk888ytxx.placelistscreen.contract.ProvidePlaceContract
import com.xxmrk888ytxx.placelistscreen.models.LocalUiEvent
import com.xxmrk888ytxx.placelistscreen.models.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlaceListViewModel @Inject constructor(
    private val providePlaceContract: ProvidePlaceContract,
    private val context: Context
) : ViewModel(),UiModel<ScreenState> {

    override fun handleEvent(event: UiEvent) {
        if(event !is LocalUiEvent) return

        when(event) {

            is LocalUiEvent.UpdatePlaces -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        isLoadingState.update { true }
                        providePlaceContract.refresh()
                    }catch (e:Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context,"No connection",Toast.LENGTH_SHORT).show()
                        }
                    } finally {
                        withContext(NonCancellable) {
                            isLoadingState.update { false }
                        }
                    }
                }
            }
        }
    }


    private val isLoadingState = MutableStateFlow(false)


    override val state: Flow<ScreenState> = combine(
        isLoadingState,
        providePlaceContract.places
    ) { isLoading,places ->
        ScreenState(isLoading,places).also { cashedState = it }
    }

    private var cashedState = ScreenState()

    override val initialValue: ScreenState
        get() = cashedState

    init {
        handleEvent(LocalUiEvent.UpdatePlaces())
    }
}