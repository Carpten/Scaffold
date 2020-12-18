package com.example.scaffold.network

import com.example.scaffold.been.DetailBean
import com.example.scaffold.been.LoginBean
import com.example.scaffold.network.model.ResponseBean
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    /**
     * 登陆
     */
    @GET("login/login")
    suspend fun login(): ResponseBean<LoginBean>

    /**
     * 列表
     */
    @GET("list/list")
    suspend fun list(): String


    /**
     * 详情
     */
    @GET("detail/detail")
    suspend fun detail(): ResponseBean<DetailBean>
}