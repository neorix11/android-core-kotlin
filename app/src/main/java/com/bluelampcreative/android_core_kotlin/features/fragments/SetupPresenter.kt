package com.bluelampcreative.android_core_kotlin.features.fragments

import com.bluelampcreative.android_core_kotlin.core.BasePresenter


class SetupPresenter : BasePresenter<SetupContract.View>(), SetupContract.Presenter {

    override fun getTextForTextChange() {
        view?.setFragmentText("this is the new text")
    }
}