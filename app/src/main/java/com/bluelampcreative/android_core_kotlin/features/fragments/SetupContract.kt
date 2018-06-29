package com.bluelampcreative.android_core_kotlin.features.fragments

import com.bluelampcreative.android_core_kotlin.core.BasePresenterContract


interface SetupContract {

    interface View {
        fun setFragmentText(text: String)
    }

    interface Presenter : BasePresenterContract<View> {
        fun getNewText()
    }
}