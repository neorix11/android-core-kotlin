package com.bluelampcreative.android_core_kotlin.features

import javax.inject.Inject


class MainPresenter @Inject constructor() : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun registerView(view: MainContract.View) {
        this.view = view
    }

    override fun deregisterView() {
        view = null
    }
}