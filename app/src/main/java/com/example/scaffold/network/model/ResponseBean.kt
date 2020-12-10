package com.example.scaffold.network.model

class ResponseBean<T>(code: Int, message: String, data: T) : BaseResponseBean(code, message) {

}