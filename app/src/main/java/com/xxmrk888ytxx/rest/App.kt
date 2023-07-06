package com.xxmrk888ytxx.rest

import android.app.Application
import com.xxmrk888ytxx.rest.DI.AppComponent
import com.xxmrk888ytxx.rest.DI.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}