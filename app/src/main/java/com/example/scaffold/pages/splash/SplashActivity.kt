package com.example.scaffold.pages.splash

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.components.BaseActivity
import com.example.scaffold.constant.RouteUrls
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = RouteUrls.SPLASH)
class SplashActivity : BaseActivity() {

    override fun init(savedInstanceState: Bundle?) {
        route(RouteUrls.LOGIN,finishAfterRoute = true)
    }
}