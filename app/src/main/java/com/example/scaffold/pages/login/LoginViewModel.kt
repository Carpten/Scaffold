package com.example.scaffold.pages.login

import androidx.lifecycle.ViewModel
import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.ApiService
import com.example.scaffold.network.NetHelper
import com.example.scaffold.network.callbacks.Callback

class LoginViewModel : ViewModel() {

    fun login(vararg callbacks: Callback<LoginBean>, success: (data: LoginBean?) -> Unit) {
        NetHelper.request({
            NetHelper.getService(ApiService::class.java).login().asResult()
        }, success, *callbacks)
    }
}