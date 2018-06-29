package com.bluelampcreative.android_core_kotlin.features.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelampcreative.android_core_kotlin.R
import com.bluelampcreative.android_core_kotlin.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_setup.*
import javax.inject.Inject


class SetupFragment : BaseFragment(), SetupContract.View {

    @Inject lateinit var presenter: SetupContract.Presenter

    companion object {
        fun create(): Fragment = SetupFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_setup, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.registerView(this)
        btn_change_text.setOnClickListener { presenter.getNewText() }
    }

    override fun setFragmentText(text: String) {
        txt_fragment_text.text = text
    }

    override fun onDetach() {
        presenter.deregisterView()
        super.onDetach()
    }
}