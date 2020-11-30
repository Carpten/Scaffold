package com.example.scaffold.app

import android.app.Application
import com.example.common.network.NetHelper

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        NetHelper.init()
    }

}