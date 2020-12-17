package com.example.scaffold.pages.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.R
import com.example.scaffold.annotations.OnClick
import com.example.scaffold.components.base.BaseActivity
import com.example.scaffold.constant.RouteUrls
import com.example.scaffold.utils.Utils

@Route(path = RouteUrls.LOGIN)
class LoginActivity : BaseActivity(R.layout.activity_login) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun init(savedInstanceState: Bundle?) {
    }

    @OnClick([R.id.btnLogin])
    fun registerClickEvents(view: View) {
        if (view.id == R.id.btnLogin) {
            viewModel.login(this) {
                route(RouteUrls.INDEX, finishAfterRoute = true)
            }
        }
    }
}
