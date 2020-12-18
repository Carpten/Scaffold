package com.example.scaffold.components.base

import android.view.View

interface IViewController {

    /**
     * 显示loading
     */
    fun showLoading()


    /**
     * 隐藏loading
     */
    fun hideLoading()

    /**
     * 显示netWorkError
     */
    fun showError(
        msg: String?,
        listener: View.OnClickListener?
    )
}