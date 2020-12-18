package com.example.scaffold.pages.mine

import android.os.Bundle
import android.view.View
import com.example.scaffold.R
import com.example.scaffold.annotations.click.OnClick
import com.example.scaffold.components.base.BaseFragment
import com.example.scaffold.constant.RouteUrls

class MineFragment : BaseFragment(R.layout.fragment_mine) {
    override fun init(view: View, savedInstanceState: Bundle?) {
    }


    @OnClick([R.id.btnPerson])
    fun registerClickEvents(view: View) {
        if (view.id == R.id.btnPerson) {
            route(RouteUrls.PERSON)
        }
    }
}