package com.bluelampcreative.android_core_kotlin.data

import io.reactivex.Observable
import javax.inject.Inject


class DataService @Inject constructor() {

    fun getTextChangedData(): Observable<String> {
        return Observable.just("This is the changed text.")
    }
}