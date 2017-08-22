package com.bluelampcreative.android_core_kotlin.features.fragments


interface SetupContract {

    interface View {
        fun setFragmentText(text: String)
    }

    interface Presetner {
        fun registerView(view: View)
        fun deregisterView()
        fun getTextForTextChange()
    }
}