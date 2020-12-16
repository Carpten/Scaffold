package com.example.scaffold.extensions

import android.view.View
import com.example.scaffold.utils.ClickUtils

fun View.clickDelay(onClick: (view: View) -> Unit) {
    setOnClickListener {
        if (ClickUtils.isClickAvailable())
            onClick(it)
    }
}