package com.xxmrk888ytxx.rest.DI

import android.content.Context
import com.xxmrk888ytxx.rest.DI.modules.AuthScreenModule
import com.xxmrk888ytxx.rest.DI.modules.DataModule
import com.xxmrk888ytxx.rest.DI.modules.DomainModule
import com.xxmrk888ytxx.rest.DI.modules.HistoryScreenModel
import com.xxmrk888ytxx.rest.DI.modules.PlaceListScreenModule
import com.xxmrk888ytxx.rest.DI.modules.SplashScreenModule
import com.xxmrk888ytxx.rest.DI.modules.UseCaseModule
import com.xxmrk888ytxx.rest.DI.modules.ViewPlaceScreenModule
import com.xxmrk888ytxx.rest.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        SplashScreenModule::class,
        UseCaseModule::class,
        AuthScreenModule::class,
        PlaceListScreenModule::class,
        ViewPlaceScreenModule::class,
        HistoryScreenModel::class
    ]
)
@AppScope
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context:Context) : AppComponent
    }

}