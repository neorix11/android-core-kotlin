package com.bluelampcreative.android_core_kotlin.dagger

import com.bluelampcreative.android_core_kotlin.features.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class, PresenterModule::class))
    abstract fun provideMainActivityInjector(): MainActivity
}