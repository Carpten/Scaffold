package com.example.scaffold.network.callbacks

import android.util.Log
import com.example.scaffold.pages.login.LoginActivity

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