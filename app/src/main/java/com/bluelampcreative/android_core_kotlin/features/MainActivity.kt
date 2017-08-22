package com.bluelampcreative.android_core_kotlin.features

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bluelampcreative.android_core_kotlin.R
import com.bluelampcreative.android_core_kotlin.core.BaseActivity
import com.bluelampcreative.android_core_kotlin.features.fragments.SetupFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter

    companion object {
        fun create(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_show_fragment.setOnClickListener { toggleFragmentContent() }
        setFragmentContent(SetupFragment.create())
    }


    override fun toggleFragmentContent() {
        if (frame_fragment_content.visibility == View.VISIBLE) {
            frame_fragment_content.visibility = View.GONE
            setButtonText("Show Fragment")
        } else {
            frame_fragment_content.visibility = View.VISIBLE
            setButtonText("Hide Fragment")
        }
    }

    override fun setButtonText(btnText: String) {
        btn_show_fragment.setText(btnText)
    }

    private fun setFragmentContent(fragment: Fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_fragment_content, fragment)
                .commit()

    }
}
