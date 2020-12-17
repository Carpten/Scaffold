package com.example.scaffold.pages.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.ApiService
import com.example.scaffold.network.NetHelper

class LoginViewModel : ViewModel() {

    /**
     * 登录请求
     */
    fun login(context: Context, onSuccess: (data: LoginBean?) -> Unit) {
        NetHelper.request(context, {
            NetHelper.getService(ApiService::class.java).login().asResult()
        }, onSuccess, wait = true)
    }
}