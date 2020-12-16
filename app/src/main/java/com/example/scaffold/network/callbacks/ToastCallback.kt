package com.example.scaffold.network.callbacks

import android.widget.Toast
import com.example.scaffold.utils.Utils

class ToastCallback<T>: Callback<T> {
    override fun onStart() {

    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
        Toast.makeText(Utils.context,error.message,Toast.LENGTH_SHORT).show()
    }

    override fun onComplete() {
    }
}