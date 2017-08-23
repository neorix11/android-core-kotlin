package com.bluelampcreative.android_core_kotlin.features

import com.bluelampcreative.android_core_kotlin.core.BasePresenterContract


interface MainContract {

    interface View {
        fun toggleFragmentContent()
        fun setButtonText(btnText: String)
    }

    interface Presenter : BasePresenterContract<View>
}