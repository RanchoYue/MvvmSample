package com.yue.mvvm.network


import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    suspend fun getHomeArticles(): ResponseBody

}