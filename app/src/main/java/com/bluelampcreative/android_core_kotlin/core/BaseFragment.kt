package com.bluelampcreative.android_core_kotlin.core

import android.app.Fragment
import android.content.Context
import dagger.android.AndroidInjection


abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidInjection.inject(this)
        super.onAttach(context)
    }
}