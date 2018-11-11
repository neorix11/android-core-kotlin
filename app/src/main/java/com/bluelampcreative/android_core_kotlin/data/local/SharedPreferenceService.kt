package com.bluelampcreative.android_core_kotlin.data.local

import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferenceService(private val sharedPreferences: SharedPreferences, private val gson: Gson) {

    fun <T : Any> saveObject(value: T, key: String) {
        sharedPreferences
                .edit()
                .putString(key, gson.toJson(value))
                .apply()
    }

    fun <T : Any> getObject(key: String, type: Class<T>): T? {
        val savedObject = sharedPreferences.getString(key, "")
        return gson.fromJson(savedObject, type)
    }

    fun clearSharedPreferences() {
        sharedPreferences.edit()
                .clear()
                .apply()
    }

    companion object {
        const val API_KEY = "api_key"
        const val SHARED_PREFS = "shared_prefs"
    }
}