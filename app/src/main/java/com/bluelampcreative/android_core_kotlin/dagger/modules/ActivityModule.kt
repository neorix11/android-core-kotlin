package com.bluelampcreative.android_core_kotlin.dagger.modules

import com.bluelampcreative.android_core_kotlin.SplashActivity
import com.bluelampcreative.android_core_kotlin.dagger.ActivityScope
import com.bluelampcreative.android_core_kotlin.features.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun provideSplashActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class, PresenterModule::class, LocalDataServiceModule::class))
    abstract fun provideMainActivityInjector(): MainActivity
}