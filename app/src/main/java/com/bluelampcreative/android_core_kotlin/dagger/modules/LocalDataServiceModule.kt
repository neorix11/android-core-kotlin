package com.bluelampcreative.android_core_kotlin.dagger.modules

import com.bluelampcreative.android_core_kotlin.data.DataService
import dagger.Module
import dagger.Provides

@Module
class LocalDataServiceModule {

    @Provides
    fun provideDataService() = DataService()
}