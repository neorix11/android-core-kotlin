package com.bluelampcreative.android_core_kotlin.data

import javax.inject.Inject


class DataService @Inject constructor() {

    fun getTextChangedData(): String = "Text has Changed"
}