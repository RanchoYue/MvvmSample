package com.yue.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yue.mvvm.base.BaseViewModel
import com.yue.mvvm.network.BaseRetrofitClient
import com.yue.mvvm.network.WanService
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class ArticleViewModel : BaseViewModel() {

    private val data = MutableLiveData<ResponseBody>()
    val article: LiveData<ResponseBody>
        get() = data

    fun doAction() {
        launch({
            val homeArticles =
                BaseRetrofitClient.getService(WanService::class.java).getHomeArticlesAsync()
            data.value = homeArticles
        }, {
            Log.d("yue_qf", "Throwable: ${it.message}")
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
}