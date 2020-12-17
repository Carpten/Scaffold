package com.example.scaffold.pages.splash

import android.os.Bundle
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.components.base.BaseActivity
import com.example.scaffold.constant.RouteUrls
import com.example.scaffold.utils.SpManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = RouteUrls.SPLASH)
class SplashActivity : BaseActivity() {

    override fun init(savedInstanceState: Bundle?) {
        if (TextUtils.isEmpty(SpManager.token)) {//无token跳转至登录页面
            route(RouteUrls.LOGIN, finishAfterRoute = true)
        } else {//有token跳转至Index页面
            route(RouteUrls.INDEX, finishAfterRoute = true)
        }
    }
}