package com.example.scaffold.network.callbacks

import android.util.Log
import com.example.scaffold.pages.login.LoginActivity

/**
 * 日志动作
 * 错误时，打印错误原因
 */
class LogCallback<T> : Callback<T> {
    override fun onStart() {
    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
        Log.e("test", "net error:${error.message}")
    }

    override fun onComplete() {
    }
}