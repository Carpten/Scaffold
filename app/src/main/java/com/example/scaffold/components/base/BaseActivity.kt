package com.example.scaffold.components.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.example.scaffold.annotations.OnClick
import com.example.scaffold.utils.ClickUtils
import java.lang.reflect.Method


abstract class BaseActivity : AppCompatActivity {

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectClickAnnotation()
        init(savedInstanceState)
        registerEventBus()
    }

    /**
     * 初始化
     */
    abstract fun init(savedInstanceState: Bundle?)

    /**
     * 注册eventBus
     */
    open fun registerEventBus() {
    }

    /**
     * 路由跳转
     * @param path 路径
     * @param finishAfterRoute 路由后是否关闭当前页面
     * @param routeHook 参数注入
     */
    fun route(
        path: String,
        finishAfterRoute: Boolean = false,
        routeHook: ((routeBuild: Postcard) -> Unit)? = null
    ) {
        val aRouter = ARouter.getInstance().build(path)
        routeHook?.invoke(aRouter)
        aRouter.navigation()
        if (finishAfterRoute) {
            finish()
        }
    }


    /**
     * OnClick注解方法，注测成点击事件
     */
    private fun injectClickAnnotation() {
        val methods: Array<Method> = javaClass.methods
        for (method in methods) {
            method.getAnnotation(OnClick::class.java)?.ids?.forEach {//通过反射api获取方法上面的注解
                if (it == -1) return
                findViewById<View>(it)?.setOnClickListener { v ->
                    try {
                        if (ClickUtils.isClickAvailable()) {
                            val typeParameters = method.parameterTypes
                            if (typeParameters.isEmpty()) {//此方法无参数
                                method.invoke(this@BaseActivity)
                            } else if (typeParameters[0] == View::class.java) {//此方法有参数
                                method.invoke(this@BaseActivity, v)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}