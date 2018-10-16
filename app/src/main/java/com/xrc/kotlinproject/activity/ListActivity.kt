package com.xrc.kotlinproject.activity

import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.presenter.ListPresenter
import com.xrc.kotlinproject.view.IListView
import kotlinx.android.synthetic.main.activity_list.*

/**
 * ListActivity
 * Created by xrc on 18/10/16.
 */
class ListActivity : BaseActivity<ListPresenter>(), IListView {
    override fun empty() {
        multi_state_view.empty()
    }

    override fun success() {
        multi_state_view.normal()
    }

    override fun failed() {
        multi_state_view.error()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun initPresenter(): ListPresenter {
        return ListPresenter(this)
    }

    override fun init() {
        mPresenter?.requestInfo()
    }

    override fun onRetry() {
        mPresenter?.requestInfo()
    }
}