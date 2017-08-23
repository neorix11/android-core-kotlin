package com.bluelampcreative.android_core_kotlin.features.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelampcreative.android_core_kotlin.R
import com.bluelampcreative.android_core_kotlin.core.BaseFragment
import com.bluelampcreative.android_core_kotlin.data.DataService
import kotlinx.android.synthetic.main.fragment_setup.*
import javax.inject.Inject


class SetupFragment : BaseFragment(), SetupContract.View {

    @Inject lateinit var presenter: SetupContract.Presenter
    @Inject lateinit var dataService: DataService

    companion object {
        fun create(): Fragment = SetupFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_setup, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.registerView(this)
        btn_change_text.setOnClickListener { presenter.getTextForTextChange() }
    }

    override fun setFragmentText(text: String) {
        txt_fragment_text.text = dataService.getTextChangedData()
    }

    override fun onDetach() {
        presenter.deregisterView()
        super.onDetach()
    }
}