package com.example.scaffold.network.callbacks

open class SimpleCallback<T> : Callback<T> {
    override fun onStart() {}
    override fun onSuccess(data: T?) {}
    override fun onError(error: Throwable) {}
    override fun onComplete() {}
}