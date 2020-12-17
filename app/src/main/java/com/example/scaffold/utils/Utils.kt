package com.example.scaffold.utils

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.widget.Toast

object Utils {

    lateinit var context: Context


    fun init(app: Application) {
        context = app
    }


    fun toast(text: String?) {
        if (!TextUtils.isEmpty(text)) {
            val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}