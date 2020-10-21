package com.yue.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yue.mvvm.base.BaseViewModel
import com.yue.mvvm.network.RetrofitClient
import okhttp3.ResponseBody

class ArticleViewModel : BaseViewModel() {

    private val data = MutableLiveData<ResponseBody>()
    val article: LiveData<ResponseBody>
        get() = data

    fun doAction() {
        launch({
            val homeArticles =
                RetrofitClient.apiService.getHomeArticles()
            data.value = homeArticles
        }, {
            Log.d("yue_qf", "Throwable: ${it.message}")
        })
    }

}