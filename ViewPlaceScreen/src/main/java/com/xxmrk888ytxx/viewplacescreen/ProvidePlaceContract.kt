package com.xxmrk888ytxx.viewplacescreen

import com.xxmrk888ytxx.viewplacescreen.models.Place
import kotlinx.coroutines.flow.Flow

interface ProvidePlaceContract {

    fun getPlace(id:String) : Flow<Place>
}