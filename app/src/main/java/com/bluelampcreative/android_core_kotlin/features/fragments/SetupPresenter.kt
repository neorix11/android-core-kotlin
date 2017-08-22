package com.bluelampcreative.android_core_kotlin.features.fragments

import javax.inject.Inject


class SetupPresenter : SetupContract.Presetner {

    @Inject constructor()

    private lateinit var view: SetupContract.View

    override fun registerView(view: SetupContract.View) {
        this.view = view
    }

    override fun getTextForTextChange() {
        view.setFragmentText("this is the new textx ")
    }
}