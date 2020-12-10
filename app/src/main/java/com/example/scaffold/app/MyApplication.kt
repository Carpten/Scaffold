package com.example.scaffold.app

import android.app.Application
import com.example.scaffold.network.NetHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NetHelper.init()
    }
}