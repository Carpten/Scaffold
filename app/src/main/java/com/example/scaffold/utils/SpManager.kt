package com.example.scaffold.utils

import android.content.Context

/**
 * Author:  Young
 * Date :   2019-07-22
 * Description:
 */
object SpManager {

    object PreferenceField {
        const val NAME = "comb"
        const val KEY_TOKEN = "KEY_TOKEN"
    }

    private val sp =
        Utils.context.getSharedPreferences(PreferenceField.NAME, Context.MODE_PRIVATE)

    /**
     * 设置Token
     */
    var token: String?
        get() = sp.getString(
            PreferenceField.KEY_TOKEN, null
        )
        set(token) = sp.edit().putString(
            PreferenceField.KEY_TOKEN, token
        ).apply()
}
