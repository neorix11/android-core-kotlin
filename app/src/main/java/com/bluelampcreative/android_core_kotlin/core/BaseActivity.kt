package com.bluelampcreative.android_core_kotlin.core

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity(), HasFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}