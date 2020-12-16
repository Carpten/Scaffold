package com.example.scaffold.utils

import android.app.Application
import android.content.Context

object Utils {

    lateinit var context: Context


    fun init(app: Application) {
        context = app
    }
}