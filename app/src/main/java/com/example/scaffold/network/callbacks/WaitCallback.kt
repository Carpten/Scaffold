package com.example.scaffold.network.callbacks

import android.content.Context
import com.example.scaffold.components.dialog.ProgressDialog

class WaitCallback<T>(val context: Context) : Callback<T> {
    private var dialog: ProgressDialog? = null

    override fun onStart() {
        try {
            if (dialog == null) {
                dialog = ProgressDialog(context)
            }
            if (dialog?.isShowing != true)
                dialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSuccess(data: T?) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onComplete() {
        dialog?.dismiss()
        dialog = null
    }
}