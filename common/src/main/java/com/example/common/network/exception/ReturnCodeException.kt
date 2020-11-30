package com.example.common.network.exception

class ReturnCodeException(val code: Int, val msg: String) : Exception(msg) {
}