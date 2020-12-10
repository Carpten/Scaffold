package com.example.scaffold.network

import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    /**
     * 登陆
     */
    @POST("login/login")
    suspend fun login(): String

    /**
     * 列表
     */
    @POST("list/list")
    suspend fun list(@Body body: @JvmSuppressWildcards Map<String, Any>): String


    /**
     * 详情
     */
    @POST("detail/detail")
    suspend fun detail(@Body body: @JvmSuppressWildcards Map<String, Any>): String
}