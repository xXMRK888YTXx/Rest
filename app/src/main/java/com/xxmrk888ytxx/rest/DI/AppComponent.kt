package com.xxmrk888ytxx.rest.DI

import android.content.Context
import com.xxmrk888ytxx.rest.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [

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