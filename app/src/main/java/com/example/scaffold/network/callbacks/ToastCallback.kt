package com.example.scaffold.network.callbacks

import com.example.scaffold.utils.Utils

class ToastCallback<T> : Callback<T> {
    override fun onStart() {

    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
        Utils.toast(error.message)
    }

    override fun onComplete() {
    }
}