package com.bluelampcreative.android_core_kotlin.dagger

import com.bluelampcreative.android_core_kotlin.features.MainContract
import com.bluelampcreative.android_core_kotlin.features.MainPresenter
import com.bluelampcreative.android_core_kotlin.features.fragments.SetupContract
import com.bluelampcreative.android_core_kotlin.features.fragments.SetupPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideMainPresenter(): MainContract.Presenter = MainPresenter()

    @Provides
    fun provideSetupPresenter(): SetupContract.Presenter = SetupPresenter()
}