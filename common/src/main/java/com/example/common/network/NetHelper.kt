package com.example.common.network

import com.example.common.network.exception.NetworkException
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object NetHelper {

    private lateinit var retrofit: Retrofit

    fun init() {
        val okHttpClient = OkHttpClient().newBuilder().build()
        retrofit = Retrofit.Builder()
            .baseUrl("http://www.baidu.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }

    /**
     * 异常统一处理
     */
    fun <T> request(
        block: suspend CoroutineScope.() -> T?,
        start: suspend CoroutineScope.() -> Unit = {},
        success: suspend CoroutineScope.(T?) -> Unit = {},
        error: suspend CoroutineScope.(Throwable) -> Unit = {},
        complete: suspend CoroutineScope.() -> Unit = {}
    ): Job {
        //flow会导致findViewById为空
        return GlobalScope.launch(Dispatchers.Main) {
            flow {
                emit(block())
            }.flowOn(Dispatchers.IO)
                .onStart {
                    start()
                }.onCompletion {
                    complete()
                }.catch { throwable ->
                    if (throwable is UnknownHostException || throwable is ConnectException
                        || throwable is SocketTimeoutException
                    ) {
                        error(NetworkException())
                    } else {
                        error(throwable)
                    }
                }
                .collect { res ->
                    success(res)
                }
        }
    }
}
