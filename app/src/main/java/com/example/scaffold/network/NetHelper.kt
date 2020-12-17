package com.example.scaffold.network

import android.content.Context
import com.example.scaffold.network.callbacks.*
import com.example.scaffold.network.exception.NetworkException
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object NetHelper {

    private lateinit var retrofit: Retrofit

    private const val baseUrl = "http://ue.iwish.site:3000/mock/60/"

    fun init() {
        val okHttpClient =
            OkHttpClient().newBuilder()
                .addNetworkInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
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
    @Suppress("EXPERIMENTAL_API_USAGE")
    fun <T> request(
        block: suspend CoroutineScope.() -> T?,
        onStart: () -> Unit = {},
        onSuccess: (T?) -> Unit = {},
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ): Job {
        //flow会导致findViewById为空
        return GlobalScope.launch(Dispatchers.Main) {
            flow {
                emit(block())
            }.flowOn(Dispatchers.IO)
                .onStart {
                    onStart()
                }.onCompletion {
                    onComplete()
                }.catch { throwable ->
                    if (throwable is UnknownHostException || throwable is ConnectException
                        || throwable is SocketTimeoutException
                    ) {
                        onError(NetworkException())
                    } else {
                        onError(throwable)
                    }
                }
                .collect { res ->
                    onSuccess(res)
                }
        }
    }


    /**
     * 异常统一处理
     */
    @Suppress("EXPERIMENTAL_API_USAGE")
    fun <T> request(
        block: suspend CoroutineScope.() -> T?,
        onSuccess: (T?) -> Unit = {},
        vararg callbacks: Callback<T>
    ): Job {
        //flow会导致findViewById为空
        return GlobalScope.launch(Dispatchers.Main) {
            flow {
                emit(block())
            }.flowOn(Dispatchers.IO)
                .onStart {
                    callbacks.forEach {
                        it.onStart()
                    }
                }.onCompletion {
                    callbacks.forEach {
                        it.onComplete()
                    }
                }.catch { throwable ->
                    val error: Throwable =
                        if (throwable is UnknownHostException || throwable is ConnectException
                            || throwable is SocketTimeoutException
                        ) NetworkException() else throwable
                    callbacks.forEach {
                        it.onError(error)
                    }

                }
                .collect { res ->
                    onSuccess(res)
                    callbacks.forEach {
                        it.onSuccess(res)
                    }
                }
        }
    }


    /**
     * 异常统一处理
     */
    @Suppress("EXPERIMENTAL_API_USAGE")
    fun <T> request(
        context: Context,
        block: suspend CoroutineScope.() -> T?,
        onSuccess: (T?) -> Unit = {},
        toast: Boolean = true,
        load: Boolean = false,
        wait: Boolean = false,
        loadError: Boolean = false
    ): Job {
        val callbacks = ArrayList<Callback<T>>()
        if (toast) {
            callbacks.add(ToastCallback())
        }
        if (load) {
            callbacks.add(LoadCallback(context))
        }
        if (wait) {
            callbacks.add(WaitCallback(context))
        }
        if (loadError) {
            callbacks.add(LoadErrorCallback(context) {
                request(context, block, onSuccess, toast, load, wait, loadError)
            })
        }


        val callbacksArray = callbacks.toTypedArray()
        return request(block, onSuccess, *callbacksArray)
    }
}
