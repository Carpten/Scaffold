package com.example.scaffold.pages.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.ApiService
import com.example.scaffold.network.NetHelper
import com.example.scaffold.network.callbacks.Callback

class LoginViewModel : ViewModel() {

    fun login(vararg callbacks: Callback<LoginBean>, onSuccess: (data: LoginBean?) -> Unit) {
        NetHelper.request({
            NetHelper.getService(ApiService::class.java).login().asResult()
        }, onSuccess, *callbacks)
    }
}