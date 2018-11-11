package com.bluelampcreative.android_core_kotlin

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.bluelampcreative.android_core_kotlin.features.MainActivity
import com.bluelampcreative.android_core_kotlin.utility.NetworkUtility
import dagger.android.AndroidInjection
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var networkUtility: NetworkUtility

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe { if(networkUtility.isInternetAvailable()) startActivity(MainActivity.create(this)) else showInternetErrorMessage() }

    }

    private fun showInternetErrorMessage() {
        MaterialDialog.Builder(this)
                .title("There is no internet connection available")
                .content("Please check your connection settings")
                .positiveText("Settings")
                .neutralText("Cancel")
                .onPositive { _, _ ->   startActivityForResult(Intent(Settings.ACTION_SETTINGS), 0);}
                .onNeutral { _, _ -> finish() }
    }
}