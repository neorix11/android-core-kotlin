package com.bluelampcreative.android_core_kotlin.core

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged.invoke(editable.toString())
        }

        override fun afterTextChanged(editable: Editable?) {
        }
    })
}