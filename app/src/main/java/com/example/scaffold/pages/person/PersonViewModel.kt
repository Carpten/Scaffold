package com.example.scaffold.pages.person

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scaffold.network.ApiService
import com.example.scaffold.network.NetHelper

class PersonViewModel : ViewModel() {

    val content = MutableLiveData<String>()

    /**
     * 详情请求
     */
    fun fetchDetail(context: Context) {
        NetHelper.request(context, {
            NetHelper.getService(ApiService::class.java).detail().asResult()
        }, onSuccess = {
            content.value = it!!.content
        }, wait = false, load = true, loadError = true, toast = false)
    }
}