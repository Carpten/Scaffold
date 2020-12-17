package com.example.scaffold.pages.index

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.scaffold.R
import com.example.scaffold.annotations.OnClick
import com.example.scaffold.components.base.BaseActivity
import com.example.scaffold.constant.RouteUrls
import com.example.scaffold.pages.home.HomeFragment
import com.example.scaffold.pages.mine.MineFragment

@Route(path = RouteUrls.INDEX)
class IndexActivity : BaseActivity(R.layout.activity_index) {

    private lateinit var homeFragment: HomeFragment
    private lateinit var mineFragment: MineFragment

    private val viewModel by viewModels<IndexViewModel>()

    override fun init(savedInstanceState: Bundle?) {
        initFragment()

    }


    @OnClick([R.id.tvHome, R.id.tvMine], false)
    fun registerClickEvents(view: View) {
        if (view.id == R.id.tvHome) {
            transFragment(0)
        } else if (view.id == R.id.tvMine) {
            transFragment(1)
        }
    }





    private fun initFragment() {
        clearFragment()
        homeFragment = HomeFragment()
        mineFragment = MineFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, homeFragment).add(R.id.container, mineFragment)
            .commitAllowingStateLoss()
        transFragment(0)
    }


    private fun clearFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments) {
            if (fragment is HomeFragment || fragment is MineFragment) {
                fragmentTransaction.remove(fragment)
            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


    private fun transFragment(position: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (position == 0) {
            fragmentTransaction.show(homeFragment)
        } else {
            fragmentTransaction.hide(homeFragment)
        }
        if (position == 1) {
            fragmentTransaction.show(mineFragment)
        } else {
            fragmentTransaction.hide(mineFragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}