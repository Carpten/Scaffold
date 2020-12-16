package com.example.scaffold.pages.index

import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.R
import com.example.scaffold.components.BaseActivity
import com.example.scaffold.constant.RouteUrls

@Route(path = RouteUrls.INDEX)
class IndexActivity : BaseActivity(R.layout.activity_index) {

    private val viewModel by viewModels<IndexViewModel>()

    override fun init(savedInstanceState: Bundle?) {
    }
}