package com.bluelampcreative.android_core_kotlin.core


abstract class BasePresenter<ViewT> : BasePresenterContract<ViewT> {

    var view: ViewT? = null

    override fun registerView(view: ViewT) {
        this.view = view
    }

    override fun deregisterView() {
        view = null
    }
}