package com.bluelampcreative.android_core_kotlin.features


interface MainContract {

    interface View {
        fun toggleFragmentContent()
        fun setButtonText(btnText: String)
    }

    interface Presenter {
        fun registerView(view: View)
        fun deregisterView()
    }
}