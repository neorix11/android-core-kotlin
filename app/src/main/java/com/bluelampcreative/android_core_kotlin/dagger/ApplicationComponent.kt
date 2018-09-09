package com.bluelampcreative.android_core_kotlin.dagger

import com.bluelampcreative.android_core_kotlin.MainApplication
import com.bluelampcreative.android_core_kotlin.dagger.modules.ActivityModule
import com.bluelampcreative.android_core_kotlin.dagger.modules.ApplicationModule
import com.bluelampcreative.android_core_kotlin.dagger.modules.LocalDataServiceModule
import com.bluelampcreative.android_core_kotlin.dagger.modules.RestApiServiceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        LocalDataServiceModule::class,
        RestApiServiceModule::class))
interface ApplicationComponent {
    fun inject(application: MainApplication)
}