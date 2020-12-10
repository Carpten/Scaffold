package com.example.scaffold.network.exception

class ReturnCodeException(val code: Int, val msg: String) : Exception(msg) {
}