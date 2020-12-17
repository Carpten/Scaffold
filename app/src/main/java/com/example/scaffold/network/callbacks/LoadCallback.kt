package com.example.scaffold.network.callbacks

import android.content.Context

class LoadCallback<T>(context: Context) : Callback<T> {
    override fun onStart() {
    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onComplete() {
    }
}