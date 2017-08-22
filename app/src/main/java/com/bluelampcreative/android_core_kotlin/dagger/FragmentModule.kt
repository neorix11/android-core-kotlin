package com.bluelampcreative.android_core_kotlin.dagger

import com.bluelampcreative.android_core_kotlin.features.fragments.SetupFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideSetupFragment(): SetupFragment
}