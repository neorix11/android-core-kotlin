package com.bluelampcreative.android_core_kotlin.features.fragments

import javax.inject.Inject


class SetupPresenter @Inject constructor() : SetupContract.Presetner {

    private var view: SetupContract.View? = null

    override fun registerView(view: SetupContract.View) {
        this.view = view
    }

    override fun getTextForTextChange() {
        view?.setFragmentText("this is the new text")
    }

    override fun deregisterView() {
        view = null
    }
}