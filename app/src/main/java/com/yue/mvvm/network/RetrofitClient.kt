package com.yue.mvvm.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val baseUrl = "https://www.baidu.com"

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.d("yue_qf", "log: $message")
                }
            })
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
            return builder.build()
        }

    val apiService: ApiService = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build().create(ApiService::class.java)
}