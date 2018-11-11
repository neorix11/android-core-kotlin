package com.bluelampcreative.android_core_kotlin.core

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in ItemT>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: ItemT)
}