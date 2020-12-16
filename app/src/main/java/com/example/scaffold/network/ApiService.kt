package com.example.scaffold.network

import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.model.ResponseBean
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    /**
     * 登陆
     */
    @POST("login/login")
    suspend fun login(): ResponseBean<LoginBean>

    /**
     * 列表
     */
    @POST("list/list")
    suspend fun list(@Body body: @JvmSuppressWildcards Map<String, Any>): String


    /**
     * 详情
     */
    @POST("detail/detail")
    suspend fun detail(@Body body: @JvmSuppressWildcards Map<String, Any>): ResponseBean<LoginBean>
}