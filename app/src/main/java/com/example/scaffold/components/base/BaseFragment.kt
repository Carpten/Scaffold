package com.example.scaffold.components.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.example.scaffold.annotations.click.ClickInject

abstract class BaseFragment : Fragment {
    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ClickInject.injectClickAnnotation(this)
        init(view, savedInstanceState)
    }

    /**
     * 初始化
     */
    abstract fun init(view: View, savedInstanceState: Bundle?)


    /**
     * 路由跳转
     * @param path 路径
     * @param routeHook 参数注入
     */
    fun route(
        path: String,
        routeHook: ((routeBuild: Postcard) -> Unit)? = null
    ) {
        val aRouter = ARouter.getInstance().build(path)
        routeHook?.invoke(aRouter)
        aRouter.navigation()
    }
}