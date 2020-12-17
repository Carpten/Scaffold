package com.example.scaffold.network.callbacks

import android.content.Context

class LoadErrorCallback<T>(context: Context, onRetry: () -> Unit) : Callback<T> {
    override fun onStart() {
    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onComplete() {
    }
}