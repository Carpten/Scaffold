package com.example.scaffold.pages.person

import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.R
import com.example.scaffold.components.base.BaseActivity
import com.example.scaffold.constant.RouteUrls
import com.example.scaffold.extensions.observe
import kotlinx.android.synthetic.main.activity_person.*

@Route(path = RouteUrls.PERSON)
class PersonActivity : BaseActivity(R.layout.activity_person) {

    private val viewModel by viewModels<PersonViewModel>()

    override fun init(savedInstanceState: Bundle?) {
        viewModel.fetchDetail(this)

        observe(viewModel.content) {
            tvContent.text = it
        }
    }
}
