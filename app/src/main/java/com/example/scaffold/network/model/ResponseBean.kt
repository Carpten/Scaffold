package com.example.scaffold.network.model

import com.example.scaffold.network.exception.ReturnCodeException

class ResponseBean<T>(code: Int, message: String, val data: T) : BaseResponseBean(code, message) {


    fun asResult(): T? {
        //成功
        if (code == 0) {
            return data
        } else {
            //状态码错误
            throw ReturnCodeException(code, message)
        }
    }
}