package com.yue.mvvm

import android.text.method.ScrollingMovementMethod
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yue.mvvm.base.BaseActivity
import com.yue.mvvm.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author yue
 */
class MainActivity : BaseActivity() {

    private lateinit var viewModel: ArticleViewModel

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        tv_show.movementMethod = ScrollingMovementMethod.getInstance();
        btn_start.setOnClickListener { viewModel.doAction() }
        btn_more.setOnClickListener { viewModel.doMore() }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        viewModel.article.observe(this, Observer {
            tv_show.text = it.string()
        })
    }

}