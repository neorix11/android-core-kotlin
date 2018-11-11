package com.bluelampcreative.android_core_kotlin.utility

import android.content.Context
import android.net.ConnectivityManager
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.getSystemService

class NetworkUtility(val context: Context) {
    fun isInternetAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}