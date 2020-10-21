package com.yue.mvvm.network

import androidx.annotation.Keep

/**
 * @author yue
 */
@Keep
data class ApiResult<T>(
    val errorCode: Int,
    val errorMsg: String,
    private val data: T?
) {
    fun apiData(): T {
        if (errorCode == 0 && data != null) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg)
        }
    }
}
