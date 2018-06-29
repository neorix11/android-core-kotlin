package com.bluelampcreative.android_core_kotlin.dagger.modules

import com.bluelampcreative.android_core_kotlin.data.DataService
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
    fun provideSetupPresenter(dataService: DataService): SetupContract.Presenter = SetupPresenter(dataService)
}