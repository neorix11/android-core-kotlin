package com.bluelampcreative.android_core_kotlin.core


interface BasePresenterContract<in ViewT> {

    fun registerView(view: ViewT)
    fun deregisterView()
}