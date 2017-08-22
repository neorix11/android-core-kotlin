package com.bluelampcreative.android_core_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelampcreative.android_core_kotlin.features.MainActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.create(this))
    }
}