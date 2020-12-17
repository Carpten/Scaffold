package com.example.scaffold.pages.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.ApiService
import com.example.scaffold.network.NetHelper
import com.example.scaffold.utils.SpManager
import com.example.scaffold.utils.Utils

class LoginViewModel : ViewModel() {

    /**
     * 登录请求
     */
    fun login(context: Context, onSuccess: (data: LoginBean) -> Unit) {
        NetHelper.request(context, {
            NetHelper.getService(ApiService::class.java).login().asResult()
        }, onSuccess = {
            SpManager.token = it!!.token
            Utils.toast("登录成功")
            onSuccess(it)
        }, wait = true)
    }
}