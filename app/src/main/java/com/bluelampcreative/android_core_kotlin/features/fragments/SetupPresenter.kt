package com.bluelampcreative.android_core_kotlin.features.fragments

import com.bluelampcreative.android_core_kotlin.core.BasePresenter
import com.bluelampcreative.android_core_kotlin.data.DataService
import javax.inject.Inject


class SetupPresenter(var dataService: DataService) : BasePresenter<SetupContract.View>(), SetupContract.Presenter {

    override fun getTextForTextChange() {
        dataService.getTextChangedData()
                .subscribe { text -> view?.setFragmentText(text) }
    }
}