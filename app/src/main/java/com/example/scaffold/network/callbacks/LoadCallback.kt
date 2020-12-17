package com.example.scaffold.network.callbacks

import android.content.Context

/**
 * 加载动作
 * 请求开始时，现实加载页面，请求结束后消失
 */
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