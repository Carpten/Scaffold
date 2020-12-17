package com.example.scaffold.components.base

import android.view.View

interface IViewController {

    /**
     * 显示等待进行条
     */
    fun showProgressDialog()

    /**
     * 隐藏等待进行条
     */
    fun dismissProgressDialog()

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