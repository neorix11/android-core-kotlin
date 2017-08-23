package com.bluelampcreative.android_core_kotlin.dagger

import com.bluelampcreative.android_core_kotlin.MainApplication
import com.bluelampcreative.android_core_kotlin.dagger.modules.ActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityModule::class))
interface ApplicationComponent {
    fun inject(application: MainApplication)
}