package com.yue.mvvm.network

import java.io.Serializable

data class ArticleList(
    val offset: Int,
    val size: Int,
    val total: Int,
    val pageCount: Int,
    val curPage: Int,
    val over: Boolean,
    val datas: List<Article>
) : Serializable