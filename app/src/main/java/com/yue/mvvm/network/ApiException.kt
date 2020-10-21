package com.yue.mvvm.network

class ApiException(var code: Int, override var message: String) : RuntimeException()