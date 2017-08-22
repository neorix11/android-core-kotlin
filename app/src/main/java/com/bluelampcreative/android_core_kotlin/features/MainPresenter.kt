package com.bluelampcreative.android_core_kotlin.features

import javax.inject.Inject


class MainPresenter : MainContract.Presenter {

    @Inject constructor()

    private lateinit var view: MainContract.View

    override fun registerView(view: MainContract.View) {
        this.view = view
    }
}