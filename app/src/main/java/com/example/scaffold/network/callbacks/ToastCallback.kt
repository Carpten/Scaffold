package com.example.scaffold.network.callbacks

import com.example.scaffold.utils.Utils

/**
 * 吐司动作
 * 请求失败时，吐司错误原因
 */
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